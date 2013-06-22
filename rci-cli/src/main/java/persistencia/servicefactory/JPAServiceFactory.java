package persistencia.servicefactory;

import persistence.jpa.JPAClienteService;
import persistence.jpa.JPADistritoService;
import persistence.jpa.JPAEmpresaService;
import persistence.jpa.JPATipoClienteService;
import persistence.service.CategoriaProductoService;
import persistence.service.ClienteService;
import persistence.service.DetallePedidoService;
import persistence.service.DistritoService;
import persistence.service.EmpresaService;
import persistence.service.ImageService;
import persistence.service.ProductoTiendaService;
import persistence.service.RepartidorService;
import persistence.service.TiendaService;
import persistence.service.TipoClienteService;

public class JPAServiceFactory extends ServiceFactory{

	@Override
	public CategoriaProductoService obtenerCategoriaProductoService() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ClienteService obtenerClienteService() {
		return new JPAClienteService();
	}

	@Override
	public DetallePedidoService obtenerDetallePedidoService() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DistritoService obtenerDistritoService() {
		return new JPADistritoService();
	}

	@Override
	public EmpresaService obtenerEmpresaService() {
		return new JPAEmpresaService();
	}

	@Override
	public persistence.service.EstadoRegistroPedidoService EstadoRegistroPedidoService() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ImageService obtenerImageService() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductoTiendaService obtenerProductoTiendaService() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RepartidorService obtenerRepartidorService() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TiendaService obtenerTiendaService() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TipoClienteService obtenerTipoClienteService() {
		return new JPATipoClienteService();
	}
	
}
