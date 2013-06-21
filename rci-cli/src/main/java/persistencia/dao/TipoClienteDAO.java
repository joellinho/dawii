package persistencia.dao;

import java.util.List;

import persistencia.entidades.TipoCliente;

public interface TipoClienteDAO {

	void insertar(TipoCliente tipoCliente);
	void actualizar(TipoCliente tipoCliente);
	void eliminar(TipoCliente tipoCliente);
	List<TipoCliente> listarTipoCliente();	
	TipoCliente obtenerPorId(int id);

}
