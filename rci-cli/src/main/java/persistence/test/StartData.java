package persistence.test;

import persistence.entity.*;
import persistence.servicefactory.*;


public class StartData {

	ServiceFactory sf = ServiceFactory.obtenerServiceFactory();
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		StartData sd = new StartData();
		
		sd.InsertarTipoCliente();
		sd.insertarTipoDocumento();
		sd.insertarTipocomprobante();
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
	
	public void insertarTipocomprobante(){
		TipocomprobanteService tcs = sf.obtenerTipocomprobanteService();
		
		if(tcs.listarComprobantes().size()<=0){
			Tipocomprobante tc = new Tipocomprobante();
			tc.setDescripcion("Boleta");
			tcs.insertar(tc);
			
			tc = new Tipocomprobante();
			tc.setDescripcion("Factura");
			tcs.insertar(tc);
		}
	}
	
		

}
