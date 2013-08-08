package persistence.jpa;

import persistence.servicefactory.ClienteService;
import persistence.servicefactory.EmpresaClienteService;
import persistence.servicefactory.EmpresacomercialService;
import persistence.servicefactory.GeneroPersonaService;
import persistence.servicefactory.PedidoService;
import persistence.servicefactory.ProductoTiendaService;
import persistence.servicefactory.SerieComprobanteService;
import persistence.servicefactory.ServiceFactory;
import persistence.servicefactory.TiendaService;
import persistence.servicefactory.TipoclienteService;
import persistence.servicefactory.TipocomprobanteService;
import persistence.servicefactory.TipodocumentoService;
import persistence.servicefactory.UbigeoDepaService;
import persistence.servicefactory.UbigeoDistService;
import persistence.servicefactory.UbigeoProvService;
import persistence.servicefactory.UbigeoService;


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
	public TiendaService obtenerTiendaService() {
		return new JPATiendaService();
	}

	@Override
	public ProductoTiendaService obtenerProductoTiendaService() {
		return new JPAProductoTiendaService();
	}

	@Override
	public PedidoService obtenerPedidoService() {
		return new JPAPedidoService();
	}

	@Override
	public TipocomprobanteService obtenerTipocomprobanteService() {
		return new JPATipocomprobanteService();
	}

	@Override
	public EmpresacomercialService obtenerEmpresacomercialService() {
		return new JPAEmpresaComercialService();
	}

	@Override
	public SerieComprobanteService obtenerSerieComprobanteService() {
		return new JPASerieComprobanteService();
	}

	
	
}
