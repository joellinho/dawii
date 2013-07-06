package persistence.jpa;

import persistence.jpa.*;
import persistencia.servicefactory.ClienteService;
import persistencia.servicefactory.ServiceFactory;
import persistencia.servicefactory.TipoclienteService;
import persistencia.servicefactory.TipodocumentoService;


public class JPAServiceFactory extends ServiceFactory{

	@Override
	public TipoclienteService obtenerTipoclienteService() {
		return new JPATipoclienteService();
	}

	@Override
	public TipodocumentoService obtenerTipoDocumentoService() {
		return new JPATipodocumentoService();
	}

	@Override
	public ClienteService obtenerClienteService() {
		return new JPAClienteService();
	}

	
	
}
