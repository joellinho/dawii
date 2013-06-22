package persistence.entidades;

import java.math.BigDecimal;

import javax.persistence.*;


/**
 * The persistent class for the detallepedido database table.
 * 
 */
@Entity
public class DetallePedido{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(columnDefinition="INT(11)")
	private int id;
	
	
	@ManyToOne(fetch = FetchType.EAGER, optional = true)
	private ProductoTienda producto;

	@Column(precision=19,scale=2)
	private BigDecimal preciounitario;

	@Column(nullable=false)
	private int cantidad;

	@ManyToOne(fetch = FetchType.EAGER)
	private Pedido pedido;

	public ProductoTienda getProducto() {
		return producto;
	}

	public void setProducto(ProductoTienda producto) {
		this.producto = producto;
	}

	public BigDecimal getPreciounitario() {
		if (this.preciounitario == null) {
			return BigDecimal.ZERO;
		}
		return this.preciounitario;
	}

	public void setPreciounitario(BigDecimal preciounitario) {
		this.preciounitario = preciounitario;
	}

	public int getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Pedido getPedido() {
		return this.pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}


	public BigDecimal getImporte() {
		return new BigDecimal(cantidad).multiply(producto.getPrecio());
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}