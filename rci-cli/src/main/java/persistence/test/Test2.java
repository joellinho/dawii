package persistence.test;

import java.util.List;

import persistence.entity.Cliente;
import persistence.entity.Tipodocumento;
import persistence.jpa.JPAClienteService;
import persistence.jpa.JPATipoclienteService;
import persistence.jpa.JPATipodocumentoService;
import persistencia.servicefactory.ServiceFactory;
import persistencia.servicefactory.TipoclienteService;
import persistencia.servicefactory.TipodocumentoService;

public class Test2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JPAClienteService cliServ = new JPAClienteService();
		
		TipodocumentoService tipoDocServ = ServiceFactory.obtenerServiceFactory().obtenerTipoDocumentoService();
		TipoclienteService tipoCliServ = ServiceFactory.obtenerServiceFactory().obtenerTipoclienteService();
		
		
		Cliente cli = new Cliente();
		cli.setApellido("apellido");
		cli.setNombre("this.nombre");
		cli.setDireccion("this.direccion");
		cli.setEmail("this.email");
		cli.setTelefono("this.telefono");
		cli.setNrodocid("this.documento");
		
		cli.setTipodocumento(tipoDocServ.listar().get(0));
		cli.setTipocliente(tipoCliServ.listarTipoCliente().get(0));
		
		cliServ.insertar(cli);
	}

}
