package persistence.jpa;

import persistencia.servicefactory.*;


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

	@Override
	public UbigeoDepaService obtenerUbigeoDepaService() {
		return new JPAUbigeoDepaService();
	}

	@Override
	public UbigeoDistService obtenerUbigeoDistService() {
		return new JPAUbigeoDistService();
	}

	@Override
	public UbigeoProvService obtenerUbigeoProvService() {
		return new JPAUbigeoProvService();
	}

	@Override
	public UbigeoService obtenerUbigeoService() {
		return new JPAUbigeoService();
	}

	@Override
	public GeneroPersonaService obtenerGeneroClienteService() {
		// TODO Auto-generated method stub
		return new JPAGeneroPersonaService();
	}

	@Override
	public EmpresaClienteService obtenerEmpresaClienteService() {
		// TODO Auto-generated method stub
		return new JPAEmpresaClienteService();
	}

	@Override
	public PedidosService obtenerPedidosService() {
		// TODO Auto-generated method stub
		return new JPAPedidosService();
	}

	
	
}
