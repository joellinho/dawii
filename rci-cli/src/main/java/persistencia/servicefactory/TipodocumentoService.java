package persistencia.servicefactory;

import java.util.List;

import persistence.entity.Tipodocumento;

public interface  TipodocumentoService {

	public void insertar(Tipodocumento tipo);
	
	public void actualizar(Tipodocumento tipo);
	
	public void eliminar(Tipodocumento tipo);
	
	public List<Tipodocumento> listar();
}
