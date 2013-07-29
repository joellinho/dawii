package persistence.servicefactory;

import java.util.List;

import persistence.entity.Ubigeo;

public interface UbigeoService {
	
	public List<Ubigeo> listarUbigeo();
	public Ubigeo obtenerUbigeo(String codDistrito);
}
