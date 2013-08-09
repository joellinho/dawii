package web.managedbean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import persistence.entity.Detallepedido;
import persistence.entity.Ubigeo;
import persistence.entity.UbigeoDepa;
import persistence.entity.UbigeoDist;
import persistence.entity.UbigeoProv;
import persistence.servicefactory.ServiceFactory;
import persistence.servicefactory.UbigeoDepaService;
import persistence.servicefactory.UbigeoDistService;
import persistence.servicefactory.UbigeoProvService;
import persistence.servicefactory.UbigeoService;
import web.managedbean.event.UbigeoSelectedEvent;
import web.managedbean.event.UbigeoSelectedListener;

@ManagedBean(name="ubigeoManaged")
@SessionScoped
public class UbigeoManaged {
	// Service
	private UbigeoProvService uProvServ = ServiceFactory.obtenerServiceFactory().obtenerUbigeoProvService();
	private UbigeoDistService uDistServ = ServiceFactory.obtenerServiceFactory().obtenerUbigeoDistService();
	private UbigeoDepaService uDepaServ = ServiceFactory.obtenerServiceFactory().obtenerUbigeoDepaService();
	private UbigeoService ubiService = ServiceFactory.obtenerServiceFactory().obtenerUbigeoService();
	
	// Datos del detalle del pedido
	private List<Detallepedido> listaDetallePedido;
	private Detallepedido selectedDetalle;
	
	// Datos de Ubigeo para obtener las tiendas
	private UbigeoDepa ubiDepaSelect;
	private UbigeoProv ubiProvSelect;	
	private UbigeoDist ubiDistSelect;	
	private List<UbigeoDepa> listaUbiDepa;	
	private List<UbigeoProv> listaUbiProv;
	private List<UbigeoDist> listaUbiDist;		

	// Ubigeo seleccionado
	private Ubigeo ubiSelect;

	// Evento ubigeo Selected	
	private List<UbigeoSelectedListener> ubigeoSelectedListeners= new ArrayList<UbigeoSelectedListener>();
	
	public synchronized void addUbigeoSelectedEventListener(UbigeoSelectedListener listener){
		this.ubigeoSelectedListeners.add(listener);
	}
	
	public synchronized void removeUbigeoSelectedEventListener(UbigeoSelectedListener listener){
		this.ubigeoSelectedListeners.remove(listener);
	}
	
	 private synchronized void fireUbigeoSelectedEvent(Ubigeo ubigeoSeleccionado) {
		UbigeoSelectedEvent event = new UbigeoSelectedEvent(this);
		event.setUbigeoSeleccionado(ubigeoSeleccionado);
		
		for(UbigeoSelectedListener usl : this.ubigeoSelectedListeners){
			usl.handleUbigeoSelectedEvent(event);
		}
	 }
	
	// Constructor
	public UbigeoManaged(){
		this.obtenerListaDepartamentos();
	}
	
	// Handle Select
	public void handleDepaChange(){
		this.obtenerListaProvincias();
	}
	
	public void handleProvChange(){
		this.obtenerListaDistritos();
	}
	
	public void handleDistChange(){		
		this.obtenerUbigeo();
	}
	
	// 
	private void obtenerUbigeo(){
		// Cada ves que se cambia el ubigeo se crea un nuevo detalle y se descarta el anterior
		this.listaDetallePedido = new ArrayList<Detallepedido>();
		
		// Ahora obtenemos el ubigeo
		if(this.ubiDistSelect!=null){
			this.ubiSelect = ubiService.obtenerUbigeo(this.ubiDistSelect.getId().getUdiCod());
			
			// Lanzamos el evento
			this.fireUbigeoSelectedEvent(ubiSelect);
		}
	}
	
	// Obtener las listas
	private void obtenerListaDepartamentos(){
		this.listaUbiDepa = uDepaServ.listarUbigeoDepa();
	}	

	private void obtenerListaProvincias(){
		if(this.ubiDepaSelect!=null){
			this.listaUbiProv = uProvServ.listarUbigeoProvPorDepa(this.ubiDepaSelect.getUdCod());
		}
		else{
			this.listaUbiProv = null;
		}
	}
	
	private void obtenerListaDistritos(){
		if(this.ubiProvSelect!=null){
			this.listaUbiDist = uDistServ.listarUbigeoDistPorProv(this.ubiProvSelect.getId().getUpCod());
		}
		else{
			this.listaUbiDist = null;
		}
	}
	
	public void forzarUbigeo(Ubigeo ubigeo){
		// El objetivo del metodo es setear el ubigeo y forzar a UbigeoDep/Prov/Dist a estar sincronizados
		
		this.ubiSelect = ubigeo;
		
		// Tenemos que buscar uno por uno:
		// Primero el Departamento 
		this.ubiDepaSelect = this.uDepaServ.obtenerPorId(this.ubiSelect.getCodDep());
		if(this.ubiDepaSelect!=null){
			
			// Updateamos la lista provincias si es que encontramos departamento
			this.obtenerListaProvincias();
			
			// Ahora obtenemos la provincia
			this.ubiProvSelect = this.uProvServ.obtenerPorId(this.ubiSelect.getCodPro(),this.ubiSelect.getCodDep());
			
			if(this.ubiProvSelect!=null){
				
				// Updateamos la lista de distritos
				this.obtenerListaDistritos();
				
				// Ahora obtenemos el distrito
				this.ubiDistSelect = this.uDistServ.obtenerPorId(this.ubiSelect.getCodDis(), 
																 this.ubiSelect.getCodPro(), 
																 this.ubiSelect.getCodDep());
				
			}		
						
			// Lanzamos el evento
			this.fireUbigeoSelectedEvent(ubiSelect);
		}
		else{
			// Si no encontramos departamento limpiamos el ubigeo
			this.ubiSelect = null;
		}
		
	}
	
	// Getters y Setters
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

	public Ubigeo getUbiSelect() {
		return ubiSelect;
	}

	public void setUbiSelect(Ubigeo ubiSelect) {
		this.ubiSelect = ubiSelect;
	}	
}
