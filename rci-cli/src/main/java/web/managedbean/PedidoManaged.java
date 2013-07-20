package web.managedbean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

import persistence.entity.*;
import persistencia.servicefactory.*;

@ManagedBean(name="pedidoManaged")
@ViewScoped
public class PedidoManaged {
	// Service
	private UbigeoProvService uProvServ = ServiceFactory.obtenerServiceFactory().obtenerUbigeoProvService();
	private UbigeoDistService uDistServ = ServiceFactory.obtenerServiceFactory().obtenerUbigeoDistService();
	private UbigeoDepaService uDepaServ = ServiceFactory.obtenerServiceFactory().obtenerUbigeoDepaService();
	private UbigeoService ubiService = ServiceFactory.obtenerServiceFactory().obtenerUbigeoService();
	private TiendaService tieService = ServiceFactory.obtenerServiceFactory().obtenerTiendaService();
	private ProductoTiendaService proTieService = ServiceFactory.obtenerServiceFactory().obtenerProductoTiendaService();
	
	
	// Datos de la cabecera del pedido que son llenados desde la página web
	private String direccionDestino;	
	private String referenciaDirDestino;
	private Ubigeo ubiSelect;
	
	// Datos del detalle del pedido
	private List<Detallepedido> listaDetallePedido;
	private Detallepedido selectedDetalle;
	
	// Datos de Ubigeo para obtener las tiendas 
	private UbigeoProv ubiProvSelect;	
	private UbigeoDist ubiDistSelect;	
	private UbigeoDepa ubiDepaSelect;	
	private List<UbigeoProv> listaUbiProv;
	private List<UbigeoDist> listaUbiDist;
	private List<UbigeoDepa> listaUbiDepa;	
	
	// Lista de tiendas
	private List<Tienda> listaTiendas;
	private Tienda tiendaSelect;
	
	// Lista de ProductoTienda
	private List<Productotienda> listaProductoTienda;
	private List<Productotienda> listaProdTiendaFliltrados;
	private Productotienda productoTiendaSelect;
	private SelectItem[] listaFranquicia;
	
	
	// Producto 
	public PedidoManaged(){
		this.inicializarData();
	}
	
	private void inicializarData(){
		this.obtenerListaDepartamentos();
		this.listaDetallePedido = new ArrayList<Detallepedido>();
		this.listaFranquicia = this.createFilterOptions(this.listaTiendas);
	}
	
	private void obtenerListaDepartamentos(){
		this.listaUbiDepa = uDepaServ.listarUbigeoDepa();
	}
	
	public void handleDepaChange(){
		this.obtenerListaProvincias();
	}
	
	public void handleProvChange(){
		this.obtenerListaDistritos();
	}
	
	public void handleDistChange(){
		this.obtenerUbigeoYtiendas();
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
  
	
	private void obtenerListaProvincias(){
		if(this.ubiDepaSelect!=null){
			this.listaUbiProv = uProvServ.listarUbigeoProvPorDepa(this.ubiDepaSelect.getUdcod());
		}
		else{
			this.listaUbiProv = null;
		}
	}
	
	private void obtenerListaDistritos(){
		if(this.ubiProvSelect!=null){
			this.listaUbiDist = uDistServ.listarUbigeoDistPorProv(this.ubiProvSelect.getId().getUpcod());
		}
		else{
			this.listaUbiDist = null;
		}
	}
	
	private void obtenerUbigeoYtiendas(){
		// Cada ves que se cambia el ubigeo se crea un nuevo detalle y se descarta el anterior
		this.listaDetallePedido = new ArrayList<Detallepedido>();
		
		// Ahora obtenemos el ubigeo
		if(this.ubiDistSelect!=null){
			this.ubiSelect = ubiService.obtenerUbigeo(this.ubiDistSelect.getId().getUdicod());
			
			// Si logramos obtener el ubigeo entonces podemos buscar la lista de tiendas
			if(this.ubiSelect!=null){ 
				this.listaTiendas = tieService.obtenerTiendasUbigeo(ubiSelect);
				
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
			else{ // En caso contrario limpiamos
				this.listaTiendas=null;
				this.listaProductoTienda = null;
			}
			
		}
		else{
			this.ubiSelect = null;
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


	public UbigeoProv getUbiProvSelect() {
		return ubiProvSelect;
	}


	public void setUbiProvSelect(UbigeoProv ubiProvSelect) {
		this.ubiProvSelect = ubiProvSelect;
	}


	public UbigeoDist getUbiDistSelect() {
		return ubiDistSelect;
	}


	public void setUbiDistSelect(UbigeoDist ubiDistSelect) {
		this.ubiDistSelect = ubiDistSelect;
	}


	public UbigeoDepa getUbiDepaSelect() {
		return ubiDepaSelect;
	}


	public void setUbiDepaSelect(UbigeoDepa ubiDepaSelect) {
		this.ubiDepaSelect = ubiDepaSelect;
	}


	public List<UbigeoProv> getListaUbiProv() {
		return listaUbiProv;
	}


	public void setListaUbiProv(List<UbigeoProv> listaUbiProv) {
		this.listaUbiProv = listaUbiProv;
	}


	public List<UbigeoDist> getListaUbiDist() {
		return listaUbiDist;
	}


	public void setListaUbiDist(List<UbigeoDist> listaUbiDist) {
		this.listaUbiDist = listaUbiDist;
	}


	public List<UbigeoDepa> getListaUbiDepa() {
		return listaUbiDepa;
	}


	public void setListaUbiDepa(List<UbigeoDepa> listaUbiDepa) {
		this.listaUbiDepa = listaUbiDepa;
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
	
	
}
