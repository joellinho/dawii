package persistence.service;

import java.util.List;

import persistence.entidades.CategoriaProducto;

public interface CategoriaProductoService {

	void insertar(CategoriaProducto categoria);
	void actualizar(CategoriaProducto categoria);
	void eliminar(CategoriaProducto categoria);
	List<CategoriaProducto> listarCategoriaProducto();	
	CategoriaProducto obtenerPorId(int id);
	
}
