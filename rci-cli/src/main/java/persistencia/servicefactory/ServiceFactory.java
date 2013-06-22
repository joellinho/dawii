package persistencia.servicefactory;

import persistence.service.CategoriaProductoService;
import persistence.service.ClienteService;
import persistence.service.DetallePedidoService;
import persistence.service.DistritoService;
import persistence.service.EmpresaService;
import persistence.service.EstadoRegistroPedidoService;
import persistence.service.ImageService;
import persistence.service.PedidoService;
import persistence.service.ProductoTiendaService;
import persistence.service.RepartidorService;
import persistence.service.TiendaService;
import persistence.service.TipoClienteService;

/**
 * La clase abstracta que representa un objeto DAO.
 * Usado para obtener el acceso a la base de datos.
 * 
 * @author Alvaro
 * @version 0.1, 20/06/2013
 */
public abstract class ServiceFactory {
	
	
	private static final TipoService DEFAULT_SERVICE = TipoService.JPA;
	
	
	public static ServiceFactory obtenerServiceFactory(TipoService tipo){
		switch(tipo){
			case JPA: return new JPAServiceFactory();
			default: return null;
		}
	}	
	
	public static ServiceFactory obtenerServiceFactory(){
		return ServiceFactory.obtenerServiceFactory(ServiceFactory.DEFAULT_SERVICE);
	}
	
	/**
	 * Enumeración que lista las posibles implementaciones del DAOFactory
	 * @author Alvaro
	 * @version 0.1, 20/06/2013
	 */
	public enum TipoService{
		JPA,
		MOCK,
	}
	
	public abstract CategoriaProductoService obtenerCategoriaProductoService();
	public abstract ClienteService obtenerClienteService();
	public abstract PedidoService obtenerPedidoService();
	public abstract DetallePedidoService obtenerDetallePedidoService();
	public abstract DistritoService obtenerDistritoService();
	public abstract EmpresaService obtenerEmpresaService();
	public abstract EstadoRegistroPedidoService obtenerEstadoRegistroPedidoService();
	public abstract ImageService obtenerImageService();
	public abstract ProductoTiendaService obtenerProductoTiendaService();
	public abstract RepartidorService obtenerRepartidorService();
	public abstract TiendaService obtenerTiendaService();
	public abstract TipoClienteService obtenerTipoClienteService();	
	
}
