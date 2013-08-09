package persistence.servicefactory;

import persistence.entity.SerieComprobante;
import persistence.entity.Tipocomprobante;

public interface SerieComprobanteService {

	public SerieComprobante obtenerSerieParaComprobante(Tipocomprobante tipo);
}
