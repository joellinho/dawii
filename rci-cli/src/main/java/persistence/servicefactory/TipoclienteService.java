package persistence.servicefactory;

import java.util.List;

import persistence.entity.Cliente;
import persistence.entity.Generopersona;
import persistence.entity.Tipocliente;
import persistence.entity.Tipodocumento;

public interface TipoclienteService {

	
	public void insertar(Tipocliente tipo);
	
	public void actualizar(Tipocliente tipo);
	
	public void eliminar(Tipocliente tipo);
	
	public List<Tipocliente> listarTipoCliente();
	
	
	
	
	
	
	
}
