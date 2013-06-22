package persistence.service;

import java.util.List;

import persistence.entidades.TipoCliente;

public interface TipoClienteService {

	void insertar(TipoCliente tipoCliente);
	void actualizar(TipoCliente tipoCliente);
	void eliminar(TipoCliente tipoCliente);
	List<TipoCliente> listarTipoCliente();	
	TipoCliente obtenerPorId(int id);

}
