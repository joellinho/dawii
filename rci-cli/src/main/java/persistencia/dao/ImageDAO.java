package persistencia.dao;

import java.util.List;

import persistencia.entidades.Image;

public interface ImageDAO {

	void insertar(Image imagen);
	void actualizar(Image imagen);
	void eliminar(Image imagen);
	List<Image> listarImage();	
	Image obtenerPorId(int id);
	
}
