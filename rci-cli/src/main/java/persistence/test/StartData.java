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

	}

	
	public void InsertarTipoCliente(){
		TipoclienteService cs = sf.obtenerTipoclienteService();
		
		if(cs.listarTipoCliente().size()<=0){
			Tipocliente tc = new Tipocliente();
			tc.setDescripcion("Regular");
			cs.insertar(tc);
		}
	}
	
	
	
	
	
}
