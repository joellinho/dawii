package persistence.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


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

	//bi-directional many-to-one association to Detallefacturacion
	@OneToMany(mappedBy="productotienda")
	private Set<Detallefacturacion> detallefacturacions;

	//bi-directional many-to-one association to Detallepedido
	@OneToMany(mappedBy="productotienda")
	private Set<Detallepedido> detallepedidos;

	//bi-directional many-to-one association to Productoempresa
    @ManyToOne
	private Productoempresa productoempresa;

	//bi-directional many-to-one association to Tienda
    @ManyToOne
	private Tienda tienda;

    public Productotienda() {
    }

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Set<Detallefacturacion> getDetallefacturacions() {
		return this.detallefacturacions;
	}

	public void setDetallefacturacions(Set<Detallefacturacion> detallefacturacions) {
		this.detallefacturacions = detallefacturacions;
	}
	
	public Set<Detallepedido> getDetallepedidos() {
		return this.detallepedidos;
	}

	public void setDetallepedidos(Set<Detallepedido> detallepedidos) {
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