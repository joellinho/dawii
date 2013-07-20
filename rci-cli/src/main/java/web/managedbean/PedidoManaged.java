package web.managedbean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

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
	
	public PedidoManaged(){
		this.inicializarData();
	}
	
	private void inicializarData(){
		this.obtenerListaDepartamentos();
		this.listaDetallePedido = new ArrayList<Detallepedido>();
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
			if(this.ubiSelect!=null){ // Si logramos obtener el ubigeo entonces podemos buscar la lista de tiendas
				this.listaTiendas = tieService.obtenerTiendasUbigeo(ubiSelect);
			}
			else{ // En caso contrario limpiamos
				this.listaTiendas=null;
			}
			
		}
		else{
			this.ubiSelect = null;
			this.listaTiendas = null;
			this.tiendaSelect = null;	
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
	
	
	
}
