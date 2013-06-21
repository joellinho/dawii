package persistencia.dao;

import java.util.List;

import persistencia.entidades.Tienda;

public interface TiendaDAO {

	void insertar(Tienda tienda);
	void actualizar(Tienda tienda);
	void eliminar(Tienda tienda);
	List<Tienda> listarTienda();	
	Tienda obtenerPorId(int id);
	
}
