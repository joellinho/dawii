package web.managedbean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.EventObject;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.UUID;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

import org.hibernate.id.GUIDGenerator;

import jxl.write.DateTime;

import persistence.entity.*;
import persistence.servicefactory.*;
import web.managedbean.event.UbigeoSelectedEvent;
import web.managedbean.event.UbigeoSelectedListener;

@ManagedBean(name="pedidoManaged")
@ViewScoped
public class PedidoManaged implements UbigeoSelectedListener{
	// Service
	private TiendaService tieService = ServiceFactory.obtenerServiceFactory().obtenerTiendaService();
	private ProductoTiendaService proTieService = ServiceFactory.obtenerServiceFactory().obtenerProductoTiendaService();
	private PedidoService pedService = ServiceFactory.obtenerServiceFactory().obtenerPedidoService();
	private TipocomprobanteService tcomService = ServiceFactory.obtenerServiceFactory().obtenerTipocomprobanteService();
	
	// Managed Bean Login
	@ManagedProperty(value="#{loginManaged}")
	private LoginManaged loginManaged;
	
	// Managed Bean Ubigeo
	@ManagedProperty(value="#{ubigeoManaged}")
	private UbigeoManaged ubigeoManaged;

	// Datos de la cabecera del pedido que son llenados desde la página web
	private String direccionDestino;	
	private String referenciaDirDestino;
	private Ubigeo ubigeoActual;
	
	// Datos del detalle del pedido
	private List<Detallepedido> listaDetallePedido;
	private Detallepedido selectedDetalle;	
	
	// Lista de tiendas
	private List<Tienda> listaTiendas;
	private Tienda tiendaSelect;
	
	// Lista tipo comprobante
	private List<Tipocomprobante> listaTipoComp;
	private Tipocomprobante tipocomprobanteSelect;
	private String nombreLabelRS = "Razón Social";
	private String razonSocial;
	
	// Lista de ProductoTienda
	private List<Productotienda> listaProductoTienda;
	private List<Productotienda> listaProdTiendaFliltrados;
	private Productotienda productoTiendaSelect;
	private SelectItem[] listaFranquicia;
	
	// Sub totales y Totales
	private BigDecimal subTotal;
	private BigDecimal impuestoConsumo;
	private BigDecimal impuestoIgv;
	private BigDecimal total;
	
	
	// Producto 
	public PedidoManaged(){
		this.inicializarData();
	}
	
	private void inicializarData(){		
		this.listaDetallePedido = new ArrayList<Detallepedido>();
		this.listaFranquicia = this.createFilterOptions(this.listaTiendas);
		this.listaTipoComp = this.tcomService.listarComprobantes();
	}		
	
	public void obtenerUbigeoDefault(){
		if(this.loginManaged.getClienteLogeado()!=null &&
		   this.loginManaged.getClienteLogeado().getUbigeo() != null){
			
			this.ubigeoManaged.forzarUbigeo(this.loginManaged.getClienteLogeado().getUbigeo());
			
		}
		
		// Por ultimo obtenemos la direccion
		this.direccionDestino = this.loginManaged.getClienteLogeado().getDireccion();
	}
	
	public String agregarProducto(){
		if(this.productoTiendaSelect != null){
			// ITeramos en los elementos para buscar si es que ya lo agregamos
			for(Detallepedido detalle : listaDetallePedido){
				// Si lo encontramos
				if(detalle.getProductotienda().getId()== this.productoTiendaSelect.getId()){
					return null; // Rompemos
				}
			}
			
			Detallepedido dp = new Detallepedido();
			dp.setProductotienda(this.productoTiendaSelect);
			dp.setCantidad(1);
			this.listaDetallePedido.add(dp);
			
			return null;
		}
		else{
			return null;
		}
	}
	
	public String removerDetalle(){
		if(this.selectedDetalle!=null && this.listaDetallePedido != null){
			this.listaDetallePedido.remove(this.selectedDetalle);
		}
		return null;
	}
	
	public void updateNombreLabelRS(){
		if(this.tipocomprobanteSelect!=null){
			if(this.tipocomprobanteSelect.getId()==1){ //BOLETA
				this.nombreLabelRS="Ref. Boleta";
			}
			else{ //FACTURA
				this.nombreLabelRS = "Razón Social";
			}
		}			
	}
	
	private SelectItem[] createFilterOptions(List<Tienda> tiendas)  {
		if(tiendas==null){
			SelectItem[] options = new SelectItem[1];  
			  
	        options[0] = new SelectItem("", "Seleccionar");  
	        return options;
		}
		else{
	        SelectItem[] options = new SelectItem[tiendas.size() + 1];  
	  
	        options[0] = new SelectItem("", "Seleccionar");  
	        
	        for(int i = 0; i < tiendas.size(); i++) {  
	            options[i + 1] = new SelectItem(tiendas.get(i) , 
	            		tiendas.get(i).getEmpresacomercial().getNombrecomercial());  
	        }  
  
        	return options;
		}
    }  
  
	public void actualizarCostos(){
		
		this.subTotal = new BigDecimal(0);
		this.impuestoConsumo = new BigDecimal(0);
		this.impuestoIgv = new BigDecimal(0);
		//BigDecimal total;
		
		for (Detallepedido detalle : this.listaDetallePedido){
			this.subTotal = this.subTotal.add( detalle.getPreciocosto() );
			BigDecimal porcentajeImpCons = detalle.getProductotienda().getTienda().getEmpresacomercial().getPorcimpconsumo();
			BigDecimal impuestoConsumoActual = detalle.getPreciocosto().multiply(porcentajeImpCons);
			this.impuestoConsumo = this.impuestoConsumo.add(impuestoConsumoActual);
		}
	
		// Ahora calculo el total
		this.impuestoIgv =this.subTotal.add(this.impuestoConsumo).multiply(new BigDecimal(0.18)); 
		this.total = this.subTotal.add(this.impuestoConsumo).add(this.impuestoIgv); 
	}
	
	public void registrarPedido(){
		// Creamos el pedido 		
		Pedido pedidoActual = new Pedido();
		pedidoActual.setDirecciondestino(this.direccionDestino);
		pedidoActual.setFechahoraregistro(new Date());
		pedidoActual.setMonto(new BigDecimal(0));
		pedidoActual.setObservaciones("");//****
		pedidoActual.setPorcentajeigv(new BigDecimal(0.18));// Atencion!!
		pedidoActual.setReferenciadirdestino(this.referenciaDirDestino); //
		pedidoActual.setDetallepedidos(this.listaDetallePedido);
		//pedidoActual.setFacturacions(null);
		pedidoActual.setTienda(this.tiendaSelect);
		pedidoActual.setDeleted("F");
		//didoActual.setEstadopedido(null);
		pedidoActual.setCliente(this.loginManaged.getClienteLogeado());
		
		// Actualizamos los detalles para que referencie el pedido
		for(Detallepedido dp : pedidoActual.getDetallepedidos()){
			dp.setPedido(pedidoActual);
		}
		
		
		//Creamos las facturas
		pedidoActual.setFacturacions(this.generarFacturaDesdePedido(pedidoActual));
		
		// Ahora que tenemos las facturas y lso detalles
		pedService.insertarPedido(pedidoActual);

		
		// Redirect yadayada
		
	}	
	
	
	// Remover
	private List<Facturacion> generarFacturaDesdePedidoOld(Pedido pedidoActual) {
		List<Facturacion> listaFacturacion = new ArrayList<Facturacion>();
		for(Detallepedido detallePedido : pedidoActual.getDetallepedidos()){
			Facturacion factura = null;
			// Buscamos si la tienda ya tiene una factura creada
			for(Facturacion fBus : listaFacturacion){
				
				if(fBus.getidTiendaTrasient()==detallePedido.getProductotienda().getTienda().getId()){
					// Si vemos que ya existe una factura, obtenemos la referencia
					factura = fBus;
				}
			}
			
			// Si no encontramos factura alguna la creamos
			
			if(factura==null){
				factura = new Facturacion();
				factura.setFechafacturacion(new Date());
				factura.setId( UUID.randomUUID().toString() ); // Debe generar el numero correcto, esta generando una UUID!
				//factura.setObservaciones(observaciones)
				factura.setPedido(pedidoActual);
				factura.setRazonsocial(this.razonSocial);
				factura.setTipocomprobante(this.tipocomprobanteSelect); 				
				factura.setDetallefacturacions(new ArrayList<Detallefacturacion>());
				factura.setidTiendaTrasient(detallePedido.getProductotienda().getTienda().getId());
				listaFacturacion.add(factura);
			}
			
			// Ahora que tenemos la factura creamos el detalle actual
			Detallefacturacion detalleFact = new Detallefacturacion();
			//detalleFact.setBruto(bruto)
			detalleFact.setCantidad(detallePedido.getCantidad());
			detalleFact.setDetallepedido(detallePedido);
			detalleFact.setFacturacion(factura);
			// Seteamos el cost neto
			detalleFact.setNeto(detallePedido.getProductotienda().getProductoempresa().getPrecioventa());
			detalleFact.setPorcentajeigv(new BigDecimal(0.18)); // De donde?
			detalleFact.setPorcentajeimpuestoconsumo( detallePedido.getProductotienda().getTienda().getEmpresacomercial().getPorcimpconsumo() );
			detalleFact.setProductotienda(detallePedido.getProductotienda());
			
			//detalleFact.setImpuestoconsumo(impuestoconsumo)
			//detalleFact.setImpuestoigv(impuestoigv)
			//detalleFact.setTipocambio(tipocambio)
			
			// Ahora agregamos el detalle
			factura.getDetallefacturacions().add(detalleFact);
		}
		return listaFacturacion;
	}	
	
	private List<Facturacion> generarFacturaDesdePedido(Pedido pedidoActual) {
		List<Facturacion> listaFacturacion = new ArrayList<Facturacion>();
		
		Facturacion factura = new Facturacion();
		factura.setFechafacturacion(new Date());
		factura.setId( UUID.randomUUID().toString() ); // Debe generar el numero correcto, esta generando una UUID!
		//factura.setObservaciones(observaciones)
		factura.setPedido(pedidoActual);
		factura.setRazonsocial(this.razonSocial);
		factura.setTipocomprobante(this.tipocomprobanteSelect); 				
		factura.setDetallefacturacions(new ArrayList<Detallefacturacion>());
		//factura.setidTiendaTrasient();
		listaFacturacion.add(factura);		
		
		for(Detallepedido detallePedido : pedidoActual.getDetallepedidos()){		
			
			// Ahora que tenemos la factura creamos el detalle actual
			Detallefacturacion detalleFact = new Detallefacturacion();
			//detalleFact.setBruto(bruto)
			detalleFact.setCantidad(detallePedido.getCantidad());
			detalleFact.setDetallepedido(detallePedido);
			detalleFact.setFacturacion(factura);
			detalleFact.setProductotienda(detallePedido.getProductotienda());
			// Seteamos el porcentaje de impuestos
			detalleFact.setPorcentajeimpuestoconsumo( detallePedido.getProductotienda().getTienda().getEmpresacomercial().getPorcimpconsumo() );
			detalleFact.setPorcentajeigv(new BigDecimal(0.18)); // De donde?
			
			// Costo neto
			detalleFact.setNeto( detallePedido.getProductotienda().getProductoempresa().getPrecioventa());
			
			// Impuestos calculados
			detalleFact.setImpuestoconsumo(detalleFact.getNeto().multiply(detalleFact.getPorcentajeimpuestoconsumo()) );
			detalleFact.setImpuestoigv(detalleFact.getNeto().multiply(detalleFact.getPorcentajeigv()) );
			
			BigDecimal bruto =  detalleFact.getNeto().add(detalleFact.getImpuestoconsumo()).add(detalleFact.getImpuestoigv());
			detalleFact.setBruto(bruto);
			
			//detalleFact.setTipocambio(tipocambio)
			
			// Ahora agregamos el detalle
			factura.getDetallefacturacions().add(detalleFact);
		}
		return listaFacturacion;
	}	
	
	
	private void obteneTiendas(Ubigeo ubigeoSeleccionado){
		// Cada ves que se cambia el ubigeo se crea un nuevo detalle y se descarta el anterior
		this.listaDetallePedido = new ArrayList<Detallepedido>();		
		
		if(ubigeoSeleccionado!=null){
			// Guardo la variable que llego del evento 
			this.ubigeoActual = ubigeoSeleccionado;
			
			// Listo las tiendas
			this.listaTiendas = tieService.obtenerTiendasUbigeo(ubigeoSeleccionado);
			
			// Si encontramos data, buscamos toda la lista de productos de todas las tienda encontradas.
			if(listaTiendas!=null && listaTiendas.size()>0){
				this.listaProductoTienda = this.proTieService.listarProductoTiendaEnTiendas(listaTiendas);
				// Por ultimo llenamos las opciones de filtrado 
				this.listaFranquicia = this.createFilterOptions(this.listaTiendas);
				
			}
			else{
				this.listaProductoTienda = null;
			}
		}
		else{
			this.ubigeoActual = null;
			this.listaTiendas = null;
			this.tiendaSelect = null;	
			this.listaProductoTienda = null;
		}
	}
		
	public String test(){
		return null;
	}

	// Getters and Setters
	
	public String getDireccionDestino() {
		return direccionDestino;
	}


	public void setDireccionDestino(String direccionDestino) {
		this.direccionDestino = direccionDestino;
	}


	public String getReferenciaDirDestino() {
		return referenciaDirDestino;
	}


	public void setReferenciaDirDestino(String referenciaDirDestino) {
		this.referenciaDirDestino = referenciaDirDestino;
	}


	public List<Detallepedido> getListaDetallePedido() {
		return listaDetallePedido;
	}


	public void setListaDetallePedido(List<Detallepedido> listaDetallePedido) {
		this.listaDetallePedido = listaDetallePedido;
	}

	public Detallepedido getSelectedDetalle() {
		return selectedDetalle;
	}

	public void setSelectedDetalle(Detallepedido selectedDetalle) {
		this.selectedDetalle = selectedDetalle;
	}

	public List<Tienda> getListaTiendas() {
		return listaTiendas;
	}

	public void setListaTiendas(List<Tienda> listaTiendas) {
		this.listaTiendas = listaTiendas;
	}

	public Tienda getTiendaSelect() {
		return tiendaSelect;
	}

	public void setTiendaSelect(Tienda tiendaSelect) {
		this.tiendaSelect = tiendaSelect;
	}

	public List<Productotienda> getListaProductoTienda() {
		return listaProductoTienda;
	}

	public void setListaProductoTienda(List<Productotienda> listaProductoTienda) {
		this.listaProductoTienda = listaProductoTienda;
	}

	public Productotienda getProductoTiendaSelect() {
		return productoTiendaSelect;
	}

	public void setProductoTiendaSelect(Productotienda productoTiendaSelect) {
		this.productoTiendaSelect = productoTiendaSelect;
	}

	public List<Productotienda> getListaProdTiendaFliltrados() {
		return listaProdTiendaFliltrados;
	}

	public void setListaProdTiendaFliltrados(
			List<Productotienda> listaProdTiendaFliltrados) {
		this.listaProdTiendaFliltrados = listaProdTiendaFliltrados;
	}

	public SelectItem[] getListaFranquicia() {
		return listaFranquicia;
	}

	public LoginManaged getLoginManaged() {
		return loginManaged;
	}

	public void setLoginManaged(LoginManaged loginManaged) {
		this.loginManaged = loginManaged;
	}

	public UbigeoManaged getUbigeoManaged() {
		return ubigeoManaged;
	}

	public void setUbigeoManaged(UbigeoManaged ubigeoManaged) {
		
		if(this.ubigeoManaged!=null){
			this.ubigeoManaged.removeUbigeoSelectedEventListener(this);
		}
		
		this.ubigeoManaged = ubigeoManaged;
		this.ubigeoManaged.addUbigeoSelectedEventListener(this);
	}
	
	@Override
	public void handleUbigeoSelectedEvent(UbigeoSelectedEvent e) {
		
		this.obteneTiendas(e.getUbigeoSeleccionado());
	}

	public Tipocomprobante getTipocomprobanteSelect() {
		return tipocomprobanteSelect;
	}

	public void setTipocomprobanteSelect(Tipocomprobante tipocomprobanteSelect) {
		this.tipocomprobanteSelect = tipocomprobanteSelect;
	}

	public List<Tipocomprobante> getListaTipoComp() {
		return listaTipoComp;
	}

	public void setListaTipoComp(List<Tipocomprobante> listaTipoComp) {
		this.listaTipoComp = listaTipoComp;
	}

	public String getNombreLabelRS() {
		return nombreLabelRS;
	}

	public void setNombreLabelRS(String nombreLabelRS) {
		this.nombreLabelRS = nombreLabelRS;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public BigDecimal getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(BigDecimal subTotal) {
		this.subTotal = subTotal;
	}

	public BigDecimal getImpuestoConsumo() {
		return impuestoConsumo;
	}

	public void setImpuestoConsumo(BigDecimal impuestoConsumo) {
		this.impuestoConsumo = impuestoConsumo;
	}

	public BigDecimal getImpuestoIgv() {
		return impuestoIgv;
	}

	public void setImpuestoIgv(BigDecimal impuestoIgv) {
		this.impuestoIgv = impuestoIgv;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	
	
}
