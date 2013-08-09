package persistence.servicefactory;

import java.util.List;

import persistence.entity.UbigeoDist;
import persistence.entity.UbigeoDistPK;
import persistence.entity.UbigeoProv;

public interface UbigeoDistService {
	
	public List<UbigeoDist> listarUbigeoDist();
	public List<UbigeoDist> listarUbigeoDistPorProv(String codProv);
	public void insertar(UbigeoDist ubigeoDist);
	public UbigeoDist obtenerPorId(UbigeoDistPK id);
	public UbigeoDist obtenerPorId(String udicod, String upcod, String udcod);
}
