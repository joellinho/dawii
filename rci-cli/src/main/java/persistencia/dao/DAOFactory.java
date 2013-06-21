package persistencia.dao;

import persistencia.dao.jpa.JPADAOFactory;

/**
 * La clase abstracta que representa un objeto DAO.
 * Usado para obtener el acceso a la base de datos.
 * 
 * @author Alvaro
 * @version 0.1, 20/06/2013
 */
public abstract class DAOFactory {
	
	
	private static final TipoDAO DEFAULT_DAO = TipoDAO.JPA;
	
	
	public static DAOFactory obtenerDAOFactory(TipoDAO tipo){
		switch(tipo){
			case JPA: return new JPADAOFactory();
			default: return null;
		}
	}	
	
	public static DAOFactory obtenerDAOFactory(){
		return DAOFactory.obtenerDAOFactory(DAOFactory.DEFAULT_DAO);
	}
	
	/**
	 * Enumeración que lista las posibles implementaciones del DAOFactory
	 * @author Alvaro
	 * @version 0.1, 20/06/2013
	 */
	public enum TipoDAO{
		JPA,
		MOCK,
	}
	
	public abstract CategoriaProductoDAO obtenerCategoriaProductoDAO();
	public abstract ClienteDAO obtenerClienteDAO();
	public abstract DetallePedidoDAO obtenerDetallePedidoDAO();
	public abstract DistritoDAO obtenerDistritoDAO();
	public abstract EmpresaDAO obtenerEmpresaDAO();
	public abstract EstadoRegistroPedidoDAO EstadoRegistroPedidoDAO();
	public abstract ImageDAO obtenerImageDAO();
	public abstract ProductoTiendaDAO obtenerProductoTiendaDAO();
	public abstract RepartidorDAO obtenerRepartidorDAO();
	public abstract TiendaDAO obtenerTiendaDAO();
	public abstract TipoClienteDAO obtenerTipoClienteDAO();	
	
}
