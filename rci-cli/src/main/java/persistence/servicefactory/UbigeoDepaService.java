package persistence.servicefactory;

import java.util.List;

import persistence.entity.UbigeoDepa;

public interface UbigeoDepaService {

	public List<UbigeoDepa> listarUbigeoDepa();
	public void insertar(UbigeoDepa ubigeoDepa);
	public UbigeoDepa obtenerPorId(String id);
	
}
