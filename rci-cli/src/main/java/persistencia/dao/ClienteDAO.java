package persistencia.dao;


import java.util.List;

import persistencia.entidades.Cliente;



public interface ClienteDAO {

	void insertar(Cliente cliente);
	void actualizar(Cliente cliente);
	void eliminar(Cliente cliente);
	List<Cliente> listarClientes();	
	Cliente obtenerPorId(int id);
	
}
