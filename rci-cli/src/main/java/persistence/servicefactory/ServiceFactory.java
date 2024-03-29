package persistence.servicefactory;

import persistence.jpa.JPAServiceFactory;

/**
 * La clase abstracta que representa un objeto DAO.
 * Usado para obtener el acceso a la base de datos.
 * 
 * @author Alvaro
 * @version 0.1, 20/06/2013
 */
public abstract class ServiceFactory {
	
	
	private static final TipoService DEFAULT_SERVICE = TipoService.JPA;
	private static JPAServiceFactory jpaFactory = new JPAServiceFactory();
	
	public static ServiceFactory obtenerServiceFactory(TipoService tipo){
		switch(tipo){
			case JPA: return jpaFactory;
			default: return null;
		}
	}	
	
	public static ServiceFactory obtenerServiceFactory(){
		return ServiceFactory.obtenerServiceFactory(ServiceFactory.DEFAULT_SERVICE);
	}
	
	public abstract TipoclienteService obtenerTipoclienteService();
	public abstract TipodocumentoService obtenerTipoDocumentoService();
	public abstract ClienteService obtenerClienteService();
	public abstract UbigeoDepaService obtenerUbigeoDepaService();
	public abstract UbigeoDistService obtenerUbigeoDistService();
	public abstract UbigeoProvService obtenerUbigeoProvService();
	public abstract UbigeoService obtenerUbigeoService();
	public abstract GeneroPersonaService obtenerGeneroClienteService();//duplicado-borrado
	public abstract EmpresaClienteService obtenerEmpresaClienteService();
	public abstract TiendaService obtenerTiendaService();
	public abstract ProductoTiendaService obtenerProductoTiendaService();
	public abstract PedidoService obtenerPedidoService();
	public abstract TipocomprobanteService obtenerTipocomprobanteService();
	public abstract EmpresacomercialService obtenerEmpresacomercialService();
	public abstract SerieComprobanteService obtenerSerieComprobanteService();
	/**
	 * Enumeración que lista las posibles implementaciones del DAOFactory
	 * @author Alvaro
	 * @version 0.1, 20/06/2013
	 */
	public enum TipoService{
		JPA,
		MOCK,
	}

	
}
