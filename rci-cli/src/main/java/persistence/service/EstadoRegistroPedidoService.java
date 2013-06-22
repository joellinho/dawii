package persistence.service;

import java.util.List;

import persistence.entidades.EstadoRegistroPedido;

public interface EstadoRegistroPedidoService {

	void insertar(EstadoRegistroPedido estadoRegistro);
	void actualizar(EstadoRegistroPedido estadoRegistro);
	void eliminar(EstadoRegistroPedido estadoRegistro);
	List<EstadoRegistroPedido> listarEstadoRegistro();	
	EstadoRegistroPedido obtenerPorId(int id);
	
}
