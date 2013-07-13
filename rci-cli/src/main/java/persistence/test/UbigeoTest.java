package persistence.test;

import java.util.List;

import persistence.entity.*;
import persistencia.servicefactory.*;


public class UbigeoTest {

	ServiceFactory sf = ServiceFactory.obtenerServiceFactory();
	
	
	
	public static void main(String[] args) {
		UbigeoTest ut = new UbigeoTest();		
	}
	
	public void LlenarTablasUbigeo(){
		UbigeoService us = sf.obtenerUbigeoService();
		UbigeoDepaService uDepServ = sf.obtenerUbigeoDepaService();
		UbigeoProvService uProvServ = sf.obtenerUbigeoProvService();
	    UbigeoDistService uDistServ = sf.obtenerUbigeoDistService();
		
		
		// Obtenemos la lista de Ubigeo
		List<Ubigeo> lista = us.listarUbigeo();
		
		Ubigeo primerUbigeo = lista.get(0);
		
		UbigeoDepa udep = new UbigeoDepa();
		
		udep.setUdcod(primerUbigeo.getCodDep());
		udep.setUdnombre(primerUbigeo.getNomDep());
		
		
		
		
		
	}
	
}
