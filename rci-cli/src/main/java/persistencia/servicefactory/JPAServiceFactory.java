package persistencia.servicefactory;

import persistence.jpa.*;
import persistence.service.*;

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
		//return new JPAClienteService();
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
	public EstadoRegistroPedidoService obtenerEstadoRegistroPedidoService() {
		return new JPAEstadoRegistroPedidoService();
	}

	@Override
	public ImageService obtenerImageService() {
		return new JPAImageService();
	}

	@Override
	public ProductoTiendaService obtenerProductoTiendaService() {
		return new JPAProductoTiendaService();
	}

	@Override
	public RepartidorService obtenerRepartidorService() {
		return new JPARepartidorService();
	}

	@Override
	public TiendaService obtenerTiendaService() {
		return new JPATiendaService();
	}

	@Override
	public TipoClienteService obtenerTipoClienteService() {
		return new JPATipoClienteService();
	}

	@Override
	public PedidoService obtenerPedidoService() {
		return new JPAPedidoService();
	}
	
}
