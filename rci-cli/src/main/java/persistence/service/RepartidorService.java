package persistence.service;

import java.util.List;

import persistence.entidades.Repartidor;

public interface RepartidorService {

	void insertar(Repartidor repartidor);
	void actualizar(Repartidor repartidor);
	void eliminar(Repartidor repartidor);
	List<Repartidor> listarRepartidor();	
	Repartidor obtenerPorId(int id);
	
}
