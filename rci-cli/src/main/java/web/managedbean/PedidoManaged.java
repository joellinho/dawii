package web.managedbean;

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
	
	// Datos de la cabecera del pedido que son llenados desde la página web
	private String dirrecionDestino;	
	private String referenciadirdestino;
	
	// Datos del detalle del pedido
	private List<Detallepedido> listaDetallePedido;
	
	// Datos de Ubigeo para obtener las tiendas 
	private UbigeoProv ubiProvSelect;	
	private UbigeoDist ubiDistSelect;	
	private UbigeoDepa ubiDepaSelect;	
	private List<UbigeoProv> listaUbiProv;
	private List<UbigeoDist> listaUbiDist;
	private List<UbigeoDepa> listaUbiDepa;
	
	
	
	
	public PedidoManaged(){
		this.obtenerListaDepartamentos();
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
	
		
	public String test(){
		return null;
	}

	// Getters and Setters
	
	public String getDirrecionDestino() {
		return dirrecionDestino;
	}


	public void setDirrecionDestino(String dirrecionDestino) {
		this.dirrecionDestino = dirrecionDestino;
	}


	public String getReferenciadirdestino() {
		return referenciadirdestino;
	}


	public void setReferenciadirdestino(String referenciadirdestino) {
		this.referenciadirdestino = referenciadirdestino;
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
	
	
	
}
