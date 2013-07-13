package persistencia.servicefactory;

import java.util.List;

import persistence.entity.Cliente;



public interface ClienteService {
	
	public void insertar(Cliente cliente);

	public void actualizar(Cliente cliente);

	public void eliminar(Cliente cliente);

	public List<Cliente> listarClientes();

	public Cliente buscarPorUserPass(String user, String pass);
}
