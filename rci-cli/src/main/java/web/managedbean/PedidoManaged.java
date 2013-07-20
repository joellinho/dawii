package web.managedbean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import persistence.entity.*;

@ManagedBean(name="pedidoManaged")
@SessionScoped
public class PedidoManaged {
	
	// Datos de la cabecera del pedido que son llenados desde la página web
	private String dirrecionDestino;	
	private String referenciadirdestino;
	
	// Datos del detalle del pedido
	private List<Detallepedido> listaDetallePedido;
	
	// Datos de Ubigeo para obtener las tiendas 
	private UbigeoProv ubiProvSelect;	
	private UbigeoDist ubiDistSelect;	
	private UbigeoDepa ubiDepaSelect;	
	private List<UbigeoProv> listaUbiProv;
	private List<UbigeoDist> listaUbiDist;
	private List<UbigeoDepa> listaUbiDepa;
	
	
	
	
}
