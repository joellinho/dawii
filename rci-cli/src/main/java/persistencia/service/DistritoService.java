package persistencia.service;

import java.util.List;
import persistencia.entidades.Distrito;

public interface DistritoService {

	void insertar(Distrito distrito);
	void actualizar(Distrito distrito);
	void eliminar(Distrito distrito);
	List<Distrito> listarDistrito();	
	Distrito obtenerPorId(int id);
	
}
