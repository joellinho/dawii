package foo;

import persistencia.dao.ClienteDAO;
import persistencia.dao.DAOFactory;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
        ClienteDAO clienteDAO = DAOFactory.obtenerDAOFactory().obtenerClienteDAO();
        
        System.out.println(clienteDAO.listarClientes().size());
    }
}
