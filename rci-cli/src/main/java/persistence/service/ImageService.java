package persistence.service;

import java.util.List;

import persistence.entidades.Image;

public interface ImageService {

	void insertar(Image imagen);
	void actualizar(Image imagen);
	void eliminar(Image imagen);
	List<Image> listarImage();	
	Image obtenerPorId(int id);
	
}
