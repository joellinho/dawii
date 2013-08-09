package persistence.servicefactory;

import java.util.List;

import persistence.entity.Generopersona;

public interface GeneroPersonaService {

	public void insertarGenero(Generopersona genero);
	public List<Generopersona> listarGenero();
	
	public Generopersona findById(int id);
}
