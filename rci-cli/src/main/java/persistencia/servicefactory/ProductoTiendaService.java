package persistencia.servicefactory;

import java.util.List;

import persistence.entity.Productotienda;
import persistence.entity.Tienda;

public interface ProductoTiendaService {
	
	public List<Productotienda> listarProductoTiendaPorTienda(Tienda tienda);
	public List<Productotienda> listarProductoTiendaEnTiendas(List<Tienda> tiendas);
}
