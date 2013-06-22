package persistence.service;

import java.util.List;

import persistence.entidades.Pedido;

public interface ProductoTiendaService {

	void insertar(Pedido pedido);
	void actualizar(Pedido pedido);
	void eliminar(Pedido pedido);
	List<Pedido> listarPedido();	
	Pedido obtenerPorId(int id);
	
}
