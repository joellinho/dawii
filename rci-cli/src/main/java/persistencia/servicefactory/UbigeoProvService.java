package persistencia.servicefactory;

import java.util.List;

import persistence.entity.UbigeoProv;
import persistence.entity.UbigeoProvPK;

public interface UbigeoProvService {

	public List<UbigeoProv> listarUbigeoProv();
	public void insertar(UbigeoProv ubigeoProv);
	public UbigeoProv obtenerPorId(UbigeoProvPK id);
}
