package persistencia.servicefactory;

import java.util.List;

import persistence.entity.Tienda;
import persistence.entity.Ubigeo;

public interface TiendaService {

	public List<Tienda> obtenerTiendasUbigeo(Ubigeo ubi);
	public Tienda obtenerTiendaPorId(int id);
}
