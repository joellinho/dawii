package persistencia.servicefactory;

import java.util.List;

import persistence.entity.Cliente;



public interface ClienteService {
	

	public abstract void insertar(Cliente cliente);

	public abstract void actualizar(Cliente cliente);

	public abstract void eliminar(Cliente cliente);

	public abstract List<Cliente> listarClientes();

}
