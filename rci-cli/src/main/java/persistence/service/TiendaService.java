package persistence.service;

import java.util.List;

import persistence.entidades.Tienda;

public interface TiendaService {

	void insertar(Tienda tienda);
	void actualizar(Tienda tienda);
	void eliminar(Tienda tienda);
	List<Tienda> listarTienda();	
	Tienda obtenerPorId(int id);
	
}
