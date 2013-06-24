package persistence.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the detallepedido database table.
 * 
 */
@Entity
public class Detallepedido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idDetallePedido;

	private int cantidad;

    @Temporal( TemporalType.TIMESTAMP)
	private Date horaentrada;

    @Temporal( TemporalType.TIMESTAMP)
	private Date horasalida;

	private BigDecimal preciocosto;

	private BigDecimal precioventa;

	private BigDecimal subtotal;

	//bi-directional many-to-one association to Productoxtienda
    @ManyToOne
	private Productoxtienda productoxtienda;

	//bi-directional many-to-one association to Registropedido
    @ManyToOne
	private Registropedido registropedido;

	//bi-directional many-to-one association to Repartidore
    @ManyToOne
	@JoinColumn(name="repartidores_idrepartidores")
	private Repartidore repartidore;

	//bi-directional many-to-one association to Facturacion
	@OneToMany(mappedBy="detallepedido")
	private Set<Facturacion> facturacions;

    public Detallepedido() {
    }

	public int getIdDetallePedido() {
		return this.idDetallePedido;
	}

	public void setIdDetallePedido(int idDetallePedido) {
		this.idDetallePedido = idDetallePedido;
	}

	public int getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Date getHoraentrada() {
		return this.horaentrada;
	}

	public void setHoraentrada(Date horaentrada) {
		this.horaentrada = horaentrada;
	}

	public Date getHorasalida() {
		return this.horasalida;
	}

	public void setHorasalida(Date horasalida) {
		this.horasalida = horasalida;
	}

	public BigDecimal getPreciocosto() {
		return this.preciocosto;
	}

	public void setPreciocosto(BigDecimal preciocosto) {
		this.preciocosto = preciocosto;
	}

	public BigDecimal getPrecioventa() {
		return this.precioventa;
	}

	public void setPrecioventa(BigDecimal precioventa) {
		this.precioventa = precioventa;
	}

	public BigDecimal getSubtotal() {
		return this.subtotal;
	}

	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}

	public Productoxtienda getProductoxtienda() {
		return this.productoxtienda;
	}

	public void setProductoxtienda(Productoxtienda productoxtienda) {
		this.productoxtienda = productoxtienda;
	}
	
	public Registropedido getRegistropedido() {
		return this.registropedido;
	}

	public void setRegistropedido(Registropedido registropedido) {
		this.registropedido = registropedido;
	}
	
	public Repartidore getRepartidore() {
		return this.repartidore;
	}

	public void setRepartidore(Repartidore repartidore) {
		this.repartidore = repartidore;
	}
	
	public Set<Facturacion> getFacturacions() {
		return this.facturacions;
	}

	public void setFacturacions(Set<Facturacion> facturacions) {
		this.facturacions = facturacions;
	}
	
}