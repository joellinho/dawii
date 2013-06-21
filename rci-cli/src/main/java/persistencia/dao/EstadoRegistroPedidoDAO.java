package persistencia.dao;

import java.util.List;

import persistencia.entidades.EstadoRegistroPedido;

public interface EstadoRegistroPedidoDAO {

	void insertar(EstadoRegistroPedido estadoRegistro);
	void actualizar(EstadoRegistroPedido estadoRegistro);
	void eliminar(EstadoRegistroPedido estadoRegistro);
	List<EstadoRegistroPedido> listarEstadoRegistro();	
	EstadoRegistroPedido obtenerPorId(int id);
	
}
