package persistencia.servicefactory;

import java.util.List;

import persistence.entity.UbigeoDist;
import persistence.entity.UbigeoDistPK;

public interface UbigeoDistService {
	
	public List<UbigeoDist> listarUbigeoDist();
	public void insertar(UbigeoDist ubigeoDist);
	public UbigeoDist obtenerPorId(UbigeoDistPK id);
}
