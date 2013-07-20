package persistencia.servicefactory;

import java.util.List;

import persistence.entity.UbigeoDist;

public interface UbigeoDistService {
	
	public List<UbigeoDist> listarUbigeoDist();
	public void insertar(UbigeoDist ubigeoDist);
	public UbigeoDist obtenerPorId(String id);
}
