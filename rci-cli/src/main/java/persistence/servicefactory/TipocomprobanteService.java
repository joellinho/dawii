package persistence.servicefactory;

import java.util.List;

import persistence.entity.Tipocomprobante;
import persistence.entity.Tipodocumento;

public interface TipocomprobanteService {
	
	public void insertar(Tipocomprobante tipo);	

	public List<Tipocomprobante> listarComprobantes();
	
	public Tipocomprobante findById(int id);
}
