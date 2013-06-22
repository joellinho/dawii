package foo;

import java.util.List;

import persistencia.entidades.Cliente;
import persistencia.entidades.Direccion;
import persistencia.entidades.Distrito;
import persistencia.entidades.TipoCliente;
import persistencia.service.ClienteService;
import persistencia.service.ServiceFactory;
import persistencia.service.DistritoService;
import persistencia.service.TipoClienteService;

/**
 * Hello world!
 *
 */
public class Data 
{
    public static void AgregarTipoCliente(){
    	TipoClienteService tipoClienteDAO = ServiceFactory.obtenerDAOFactory().obtenerTipoClienteService();
    	
    	if(tipoClienteDAO.listarTipoCliente().size()<=0){
    		TipoCliente tipo = new TipoCliente();
    		tipo.setDescripcion("Regular");
    		tipoClienteDAO.insertar(tipo);
    	}
    }
    
   public static void AgregarDistrito(){
	   DistritoService distritoDAO = ServiceFactory.obtenerDAOFactory().obtenerDistritoService();
	   if(distritoDAO.listarDistrito().size()<=0){
		   Distrito distrito = new Distrito();
		   distrito.setDescripcion("Rimac");
		   distritoDAO.insertar(distrito);
	   }	   
   }
    
    
   public static void AgregarCliente(){
	   ClienteService clienteDAO = ServiceFactory.obtenerDAOFactory().obtenerClienteService();
	   DistritoService distritoDAO = ServiceFactory.obtenerDAOFactory().obtenerDistritoService();
	   TipoClienteService tipoClienteDAO = ServiceFactory.obtenerDAOFactory().obtenerTipoClienteService();
	   
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
}
