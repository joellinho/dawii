package foo;

import java.util.List;

import persistence.entidades.Cliente;
import persistence.entidades.Direccion;
import persistence.entidades.Distrito;
import persistence.entidades.Empresa;
import persistence.entidades.ProductoTienda;
import persistence.entidades.Tienda;
import persistence.entidades.TipoCliente;
import persistence.service.ClienteService;
import persistence.service.DistritoService;
import persistence.service.EmpresaService;
import persistence.service.TiendaService;
import persistence.service.TipoClienteService;
import persistencia.servicefactory.ServiceFactory;

/**
 * Hello world!
 *
 */
public class Data 
{	
	private ServiceFactory serviceFactory = ServiceFactory.obtenerServiceFactory();
	
	public void AgregarTipoCliente(){
    	System.out.println("===============================");
    	System.out.println("Intentando insertar TipoCliente");
    	TipoClienteService tipoClienteDAO = serviceFactory.obtenerTipoClienteService();
    	
    	if(tipoClienteDAO.listarTipoCliente().size()<=0){
    		TipoCliente tipo = new TipoCliente();
    		tipo.setDescripcion("Regular");
    		tipoClienteDAO.insertar(tipo);
    		System.out.println("Insertado 1 tipo ciente.");
    	}
    	else{
    		System.out.println("Se encontraron TipoClientes, no se insertaran nuevos");
    	}
    }
    
	public void AgregarDistrito(){
		DistritoService distritoDAO = serviceFactory.obtenerDistritoService();
	    if(distritoDAO.listarDistrito().size()<=0){
	    	Distrito distrito = new Distrito();
		    distrito.setDescripcion("Rimac");
		    distritoDAO.insertar(distrito);
	    }	   
    }
    
    
	public void AgregarCliente(){
	    ClienteService clienteDAO = serviceFactory.obtenerClienteService();
	    DistritoService distritoDAO = serviceFactory.obtenerDistritoService();
	    TipoClienteService tipoClienteDAO = serviceFactory.obtenerTipoClienteService();
	   
	    //Obtenemos el distrito a usar
	    List<Distrito> listaDistrito = distritoDAO.listarDistrito();
	    Distrito distrito;
	    if(listaDistrito.size()>0){
	 	    distrito = listaDistrito.get(0);		   
	    }
	    else{
		    System.out.println("No existen distritos disponibles.");
		    return;
	    }
	   
	    //Obtenemos el tipo cliente a usar
	    List<TipoCliente> listaTipoClientes = tipoClienteDAO.listarTipoCliente();
	    TipoCliente tipoCliente;
	    if(listaTipoClientes.size()>0){
		    tipoCliente = listaTipoClientes.get(0);
	    }
	    else{
		    System.out.println("No existen tipo clientes.");
		    return;
	    }
	   
   	    //Creamos el cliente
	    if(clienteDAO.listarClientes().size()<=0){
		    Direccion direccion = new Direccion();
		    direccion.setCalle("Calle");
		    direccion.setDistrito(distrito);
		    direccion.setLote("lote");
		    direccion.setNumero("numero");
		    direccion.setUrbanizacion("urbanizacion");
		    
		    Cliente cliente = new Cliente();
		    cliente.setApellido("Ccatamayo");
		    cliente.setDireccion(direccion);
		    cliente.setDni("DNI");
		    cliente.setEmail("Email");
		    cliente.setNombre("Alvaro");
		    cliente.setTelefono("Telefono");
		    cliente.setTipocliente(tipoCliente);
		   
		    clienteDAO.insertar(cliente);	   		   
	   }
   }

	public void AgregarEmpresa(){
		EmpresaService empresaService = serviceFactory.obtenerEmpresaService();
		
		if(empresaService.listarEmpresa().size()<=0){		
			Empresa empresa = new Empresa();
			empresa.setNombre("KFC");
			empresa.setNombrecomercial("KFC");
			empresa.setRuc("20123456785");
			empresaService.insertar(empresa);
		}
	}
	
	public void AgregarTienda(){
		TiendaService tiendaService = serviceFactory.obtenerTiendaService();
		EmpresaService empresaService = serviceFactory.obtenerEmpresaService();
		DistritoService distritoDAO = serviceFactory.obtenerDistritoService();
		
		// Obtenemos la empresa a usar para la tienda
		List<Empresa> listaEmpresa = empresaService.listarEmpresa();
		Empresa empresa;
		if(listaEmpresa.size()<=0){
			empresa = listaEmpresa.get(0);
		}
		else{
			System.out.println("No se econtraron empresas para ser usadas en la inserción de Tienda.");
			return;
		}
		
		//Obtenemos el distrito a usar para la tienda
	    List<Distrito> listaDistrito = distritoDAO.listarDistrito();
	    Distrito distrito;
	    if(listaDistrito.size()>0){
	 	    distrito = listaDistrito.get(0);		   
	    }
	    else{
		    System.out.println("No existen distritos disponibles para ser usados en la insercion de Tienda.");
		    return;
	    }
		
		Tienda tienda = new Tienda();
		tienda.setCalle("Calle");
		tienda.setTelefono("Telefono");
		tienda.setDistrito(distrito);
		tienda.setEmpresa(empresa);
		tienda.setDescripcion("KFC Rimac?");		
		
		tiendaService.insertar(tienda);
	}
	
	public void AgregarCategoriaProducto(){
		
	}
	
	public void AgregarProducto(){
		TiendaService tiendaService = serviceFactory.obtenerTiendaService();
		
		List<Tienda> listaTienda = tiendaService.listarTienda();
		Tienda tienda;
		if(listaTienda.size()>0){
			tienda = listaTienda.get(0);			
		}
		else{
			System.out.println("No existen tiendas disponibles para ser usados en la incersion de producto.");
			return;
		}	
		
		ProductoTienda producto = new ProductoTienda();
		producto.set|
		
	}
	
}
