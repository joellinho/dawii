package persistence.service;

import java.util.List;

import persistence.entidades.ProductoTienda;

public interface ProductoTiendaService {

	void insertar(ProductoTienda producto);
	void actualizar(ProductoTienda producto);
	void eliminar(ProductoTienda producto);
	List<ProductoTienda> listarProducto();	
	ProductoTienda obtenerPorId(int id);
	
}
