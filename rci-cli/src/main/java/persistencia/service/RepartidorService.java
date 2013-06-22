package persistencia.service;

import java.util.List;

import persistencia.entidades.Repartidor;

public interface RepartidorService {

	void insertar(Repartidor repartidor);
	void actualizar(Repartidor repartidor);
	void eliminar(Repartidor repartidor);
	List<Repartidor> listarRepartidor();	
	Repartidor obtenerPorId(int id);
	
}
