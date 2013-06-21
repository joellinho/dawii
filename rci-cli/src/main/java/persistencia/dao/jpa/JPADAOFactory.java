package persistencia.dao.jpa;

import persistencia.dao.CategoriaProductoDAO;
import persistencia.dao.ClienteDAO;
import persistencia.dao.DAOFactory;
import persistencia.dao.DetallePedidoDAO;
import persistencia.dao.DistritoDAO;
import persistencia.dao.EmpresaDAO;
import persistencia.dao.ImageDAO;
import persistencia.dao.ProductoTiendaDAO;
import persistencia.dao.RepartidorDAO;
import persistencia.dao.TiendaDAO;
import persistencia.dao.TipoClienteDAO;

public class JPADAOFactory extends DAOFactory{

	@Override
	public CategoriaProductoDAO obtenerCategoriaProductoDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ClienteDAO obtenerClienteDAO() {
		return new JPAClienteDAO();
	}

	@Override
	public DetallePedidoDAO obtenerDetallePedidoDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DistritoDAO obtenerDistritoDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmpresaDAO obtenerEmpresaDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public persistencia.dao.EstadoRegistroPedidoDAO EstadoRegistroPedidoDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ImageDAO obtenerImageDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductoTiendaDAO obtenerProductoTiendaDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RepartidorDAO obtenerRepartidorDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TiendaDAO obtenerTiendaDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TipoClienteDAO obtenerTipoClienteDAO() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
