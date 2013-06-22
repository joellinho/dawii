package persistencia.jpa;

import persistencia.service.CategoriaProductoService;
import persistencia.service.ClienteService;
import persistencia.service.ServiceFactory;
import persistencia.service.DetallePedidoService;
import persistencia.service.DistritoService;
import persistencia.service.EmpresaService;
import persistencia.service.ImageService;
import persistencia.service.ProductoTiendaService;
import persistencia.service.RepartidorService;
import persistencia.service.TiendaService;
import persistencia.service.TipoClienteService;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public persistencia.service.EstadoRegistroPedidoService EstadoRegistroPedidoService() {
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
