package persistence.test;

import persistence.entity.Tipocliente;
import persistence.entity.Tipodocumento;
import persistence.jpa.JPATipoclienteService;
import persistence.jpa.JPATipodocumentoService;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		JPATipodocumentoService tipodocServ = new JPATipodocumentoService();
		JPATipoclienteService tipocliServ = new JPATipoclienteService();
		
		Tipocliente tipoCli = new Tipocliente();
		tipoCli.setDescripcion("Regular");
		
		tipocliServ.insertar(tipoCli);
	    tipocliServ.listarTipoCliente();
		
		Tipodocumento tipoDoc = new Tipodocumento();
		tipoDoc.setDescripcion("DNI");
		
		tipodocServ.listar();
		tipodocServ.insertar(tipoDoc);
		
		
	
	}

}
