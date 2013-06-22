package foo;

import java.util.List;

import persistencia.dao.ClienteDAO;
import persistencia.dao.DAOFactory;
import persistencia.dao.DistritoDAO;
import persistencia.dao.TipoClienteDAO;
import persistencia.entidades.Cliente;
import persistencia.entidades.Direccion;
import persistencia.entidades.Distrito;
import persistencia.entidades.TipoCliente;

/**
 * Hello world!
 *
 */
public class Data 
{

    
    public static void AgregarTipoCliente(){
    	TipoClienteDAO tipoClienteDAO = DAOFactory.obtenerDAOFactory().obtenerTipoClienteDAO();
    	
    	if(tipoClienteDAO.listarTipoCliente().size()<=0){
    		TipoCliente tipo = new TipoCliente();
    		tipo.setDescripcion("Regular");
    		tipoClienteDAO.insertar(tipo);
    	}
    }
    
   public static void AgregarDistrito(){
	   DistritoDAO distritoDAO = DAOFactory.obtenerDAOFactory().obtenerDistritoDAO();
	   if(distritoDAO.listarDistrito().size()<=0){
		   Distrito distrito = new Distrito();
		   distrito.setDescripcion("Rimac");
		   distritoDAO.insertar(distrito);
	   }	   
   }
    
    
   public static void AgregarCliente(){
	   ClienteDAO clienteDAO = DAOFactory.obtenerDAOFactory().obtenerClienteDAO();
	   DistritoDAO distritoDAO = DAOFactory.obtenerDAOFactory().obtenerDistritoDAO();
	   TipoClienteDAO tipoClienteDAO = DAOFactory.obtenerDAOFactory().obtenerTipoClienteDAO();
	   
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
