package persistencia.servicefactory;

import java.util.List;

import persistence.entity.Cliente;
import persistence.entity.Generopersona;

public interface GeneroPersonaService {

	public void insertarGenero(Generopersona genero);
	public List<Generopersona> listarGenero();
	
}
