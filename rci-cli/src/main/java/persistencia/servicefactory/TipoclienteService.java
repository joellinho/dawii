package persistencia.servicefactory;

import java.util.List;

import persistence.entity.Tipocliente;

public interface TipoclienteService {

	
	public void insertar(Tipocliente tipo);
	
	public void actualizar(Tipocliente tipo);
	
	public void eliminar(Tipocliente tipo);
	
	public List<Tipocliente> listarTipoCliente();
}
