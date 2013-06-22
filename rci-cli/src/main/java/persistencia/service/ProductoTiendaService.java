package persistencia.service;

import java.util.List;

import persistencia.entidades.Pedido;

public interface ProductoTiendaService {

	void insertar(Pedido pedido);
	void actualizar(Pedido pedido);
	void eliminar(Pedido pedido);
	List<Pedido> listarPedido();	
	Pedido obtenerPorId(int id);
	
}
