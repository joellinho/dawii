package persistence.test;

import persistence.entity.*;
import persistencia.servicefactory.*;


public class StartData {

	ServiceFactory sf = ServiceFactory.obtenerServiceFactory();
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		StartData sd = new StartData();
		
		sd.InsertarTipoCliente();
		sd.insertarTipoDocumento();
		
		//GeneroPersonaService gp = ServiceFactory.
	}

	
	public void InsertarTipoCliente(){
		TipoclienteService cs = sf.obtenerTipoclienteService();
		
		if(cs.listarTipoCliente().size()<=0){
			Tipocliente tc = new Tipocliente();
			tc.setDescripcion("Regular");
			cs.insertar(tc);
		}
	}
	
	public void insertarGenero(){
		GeneroPersonaService cs=sf.obtenerGeneroClienteService();
		
		if(cs.listarGenero().size()<=0){
			Generopersona gc=new Generopersona();
			gc.setDescripcion("Masculino");
			gc.setDescripcion("Femenino");
			cs.insertarGenero(gc);
		}
	}
	
	public void insertarTipoDocumento(){
		TipodocumentoService cs=sf.obtenerTipoDocumentoService();
		
		if(cs.listarDocumento().size()<=0){
			Tipodocumento td=new Tipodocumento();
			td.setDescripcion("DNI");
			cs.insertar(td);
		}
	}
	
	
	public void insertarEmpresaCliente(){
		EmpresaClienteService cs=sf.obtenerEmpresaClienteService();
		
		if(cs.listarEmpresaCliente().size()<=0){
			Empresacliente ec=new Empresacliente();
			ec.setRazonsocial("empresa 01");
			ec.setRazonsocial("empresa 02");
			cs.insertarEmpresaCliente(ec);
		}
	}
		

}
