package persistence.test;

import java.util.List;

import persistence.entity.*;
import persistence.servicefactory.*;

public class SelectData {

	ServiceFactory sf = ServiceFactory.obtenerServiceFactory();
	
	public static void main(String[] args) {
		SelectData sd = new SelectData();
		sd.ListarUbigeo();
		sd.ListarUbigeoDist();
	}

	public void ListarUbigeo(){
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
	
	
	
}
