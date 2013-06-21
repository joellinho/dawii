package persistencia.dao;

import java.util.List;

import persistencia.entidades.CategoriaProducto;

public interface CategoriaProductoDAO {

	void insertar(CategoriaProducto categoria);
	void actualizar(CategoriaProducto categoria);
	void eliminar(CategoriaProducto categoria);
	List<CategoriaProducto> listarCategoriaProducto();	
	CategoriaProducto obtenerPorId(int id);
	
}
