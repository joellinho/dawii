package persistence.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import persistence.entity.*;
import persistence.jpa.JPASerieComprobanteService;
import persistence.jpa.JPATipocomprobanteService;
import persistence.jpa.JPAUtil;
import persistence.servicefactory.*;

public class SelectData {

	ServiceFactory sf = ServiceFactory.obtenerServiceFactory();
	
	public static void main(String[] args) {
		SelectData sd = new SelectData();
		sd.ListarTest();
		//sd.ListarUbigeo();
		//sd.ListarUbigeoDist();
	}

	public void ListarUbigeo(){
		PedidoService ps = sf.obtenerPedidoService();
		ps.listarPedidos();
		
		UbigeoService us = sf.obtenerUbigeoService();
		
		List<Ubigeo> listaUbigeo = us.listarUbigeo();
		System.out.println("Lista Codigo Ubigeo concatenado");		
		for(Ubigeo u : listaUbigeo){
			System.out.println(u.toString());
		}
		
		System.out.println("===============================");	
	}
	
	public void ListarUbigeoDist(){
		UbigeoDistService uds = sf.obtenerUbigeoDistService();
		
		List<UbigeoDist> listaUbigeoDist = uds.listarUbigeoDist();		
		System.out.println("Lista Codigo UbigeoDistrito concatenado");
		
		for(UbigeoDist u : listaUbigeoDist){
			System.out.println(u.toString());
		}
		
		System.out.println("===============================");
	}
	
	public void ListarTest(){
		EntityManager em = JPAUtil.getEntityManager();
		try{
			String query = "SELECT sc FROM SerieComprobante sc";
			TypedQuery<SerieComprobante> emquery = em.createQuery(query,SerieComprobante.class);
			emquery.getResultList();
		}
		finally{
			em.close();
		}
		JPATipocomprobanteService tcs = new JPATipocomprobanteService();
		List<Tipocomprobante> lista =  tcs.listarComprobantes();
		if(lista.size()>0){
			JPASerieComprobanteService jscs = new JPASerieComprobanteService();
			System.out.println("Here");
			System.out.println(jscs.obtenerSerieParaComprobante(lista.get(0)).getId());
			
		}
	}
	
	
}
