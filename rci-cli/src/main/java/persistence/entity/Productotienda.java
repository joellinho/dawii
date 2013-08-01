package persistence.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the productotienda database table.
 * 
 */
@Entity
public class Productotienda implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String observaciones;

	//bi-directional many-to-one association to Detallefacturacion
	@OneToMany(mappedBy="productotienda")
	private List<Detallefacturacion> detallefacturacions;

	//bi-directional many-to-one association to Detallepedido
	@OneToMany(mappedBy="productotienda")
	private List<Detallepedido> detallepedidos;

	//bi-directional many-to-one association to Productoempresa
    @ManyToOne(fetch=FetchType.EAGER)
	private Productoempresa productoempresa;

	//bi-directional many-to-one association to Tienda
    @ManyToOne(fetch=FetchType.EAGER)
	private Tienda tienda;

    public Productotienda() {
    }

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public List<Detallefacturacion> getDetallefacturacions() {
		return this.detallefacturacions;
	}

	public void setDetallefacturacions(List<Detallefacturacion> detallefacturacions) {
		this.detallefacturacions = detallefacturacions;
	}
	
	public List<Detallepedido> getDetallepedidos() {
		return this.detallepedidos;
	}

	public void setDetallepedidos(List<Detallepedido> detallepedidos) {
		this.detallepedidos = detallepedidos;
	}
	
	public Productoempresa getProductoempresa() {
		return this.productoempresa;
	}

	public void setProductoempresa(Productoempresa productoempresa) {
		this.productoempresa = productoempresa;
	}
	
	public Tienda getTienda() {
		return this.tienda;
	}

	public void setTienda(Tienda tienda) {
		this.tienda = tienda;
	}
	
}