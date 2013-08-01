package persistence.servicefactory;

import java.util.List;

import persistence.entity.Pedido;

public interface PedidoService {

	public void insertarPedido(Pedido pedido);
	public List<Pedido> listarPedidos();
}
