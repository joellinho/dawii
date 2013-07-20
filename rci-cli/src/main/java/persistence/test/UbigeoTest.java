package persistence.test;

import java.util.List;

import persistence.entity.*;
import persistencia.servicefactory.*;


public class UbigeoTest {

	ServiceFactory sf = ServiceFactory.obtenerServiceFactory();
	
	
	
	public static void main(String[] args) {
		UbigeoTest ut = new UbigeoTest();		
		ut.LlenarTablasUbigeo();
	}
	
	public void LlenarTablasUbigeo(){
		UbigeoService us = sf.obtenerUbigeoService();
		UbigeoDepaService uDepaServ = sf.obtenerUbigeoDepaService();
		UbigeoProvService uProvServ = sf.obtenerUbigeoProvService();
	    UbigeoDistService uDistServ = sf.obtenerUbigeoDistService();
		
		
		// Obtenemos la lista de Ubigeo
		List<Ubigeo> listaUbigeo = us.listarUbigeo();
		UbigeoDepa udepa = null;
		UbigeoProv uprov = null;
		UbigeoDist udist = null;
		
		// Iteramos esta lista
		for(Ubigeo ubi : listaUbigeo){
			
			// Comprobamos si ya tenemos el depa del loop anterior, en caso de tenerla ya no tenemos que buscarla
			if(udepa==null || !udepa.getUdcod().equals(ubi.getCodDep())){
				udepa = uDepaServ.obtenerPorId(ubi.getCodDep());// La buscamos
				
				if(udepa==null){// Si no encontramos nada debemos crearla e insertarla
					udepa = new UbigeoDepa();
					udepa.setUdcod(ubi.getCodDep());
					udepa.setUdnombre(ubi.getNomDep());
					uDepaServ.insertar(udepa);
				}
				
			}
			
			// En este punto tenemos el departamento, vamos por la provincia, mismo proceso
			// Comprobamos si ya tenemos
			
			// Creamos la key por la que buscaremos
			UbigeoProvPK uppk = new UbigeoProvPK();
			uppk.setUdcod(udepa.getUdcod());
			uppk.setUpcod(ubi.getCodPro());		
			
			if(uprov==null || !uprov.getId().equals(uppk)){						
				
				uprov = uProvServ.obtenerPorId(uppk);// la buscamos en caso que no
				
				if(uprov == null){//Si no encontramos insertamos
					uprov = new UbigeoProv();
						
					uprov.setId(uppk);
					uprov.setUbigeodepa(udepa);
					uprov.setUpnombre(ubi.getNomProv());
					uProvServ.insertar(uprov);
				}
			}
			
			// En este punto tenemos las provincias, vamos por el departamento
			
			// Creamos la key
			UbigeoDistPK udpk = new UbigeoDistPK();
			udpk.setUdcod(udepa.getUdcod());
			udpk.setUpcod(uprov.getId().getUpcod());
			udpk.setUdicod(ubi.getCodDis());
			
			if(udist==null || !udist.getId().equals(udpk)){
				udist = uDistServ.obtenerPorId(udpk);
				
				if(udist == null){
					udist = new UbigeoDist();
					
					udist.setId(udpk);
					udist.setUbigeoprov(uprov);
					udist.setUdinombre(ubi.getNomDist());
					
					uDistServ.insertar(udist);
				}
			}
			
		}
		
		
	}
	
}