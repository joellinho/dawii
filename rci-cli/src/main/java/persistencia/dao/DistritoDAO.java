package persistencia.dao;

import java.util.List;
import persistencia.entidades.Distrito;

public interface DistritoDAO {

	void insertar(Distrito distrito);
	void actualizar(Distrito direccion);
	void eliminar(Distrito direccion);
	List<Distrito> listarDistrito();	
	Distrito obtenerPorId(int id);
	
}
