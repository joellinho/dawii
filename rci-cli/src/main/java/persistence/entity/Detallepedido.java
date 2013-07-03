package persistence.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the detallepedido database table.
 * 
 */
@Entity
public class Detallepedido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private int cantidad;

    @Temporal( TemporalType.TIMESTAMP)
	private Date horasalida;

	private BigDecimal preciounitario;

	//bi-directional one-to-one association to Detallefacturacion
	@OneToOne(mappedBy="detallepedido")
	private Detallefacturacion detallefacturacion;

	//bi-directional many-to-one association to Documentocomercial
    @ManyToOne
	@JoinColumn(name="doccom_id")
	private Documentocomercial documentocomercial;

	//bi-directional many-to-one association to Productotienda
    @ManyToOne
	private Productotienda productotienda;

	//bi-directional many-to-one association to Repartidor
    @ManyToOne
	private Repartidor repartidor;

    public Detallepedido() {
    }

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Date getHorasalida() {
		return this.horasalida;
	}

	public void setHorasalida(Date horasalida) {
		this.horasalida = horasalida;
	}

	public BigDecimal getPreciounitario() {
		return this.preciounitario;
	}

	public void setPreciounitario(BigDecimal preciounitario) {
		this.preciounitario = preciounitario;
	}

	public Detallefacturacion getDetallefacturacion() {
		return this.detallefacturacion;
	}

	public void setDetallefacturacion(Detallefacturacion detallefacturacion) {
		this.detallefacturacion = detallefacturacion;
	}
	
	public Documentocomercial getDocumentocomercial() {
		return this.documentocomercial;
	}

	public void setDocumentocomercial(Documentocomercial documentocomercial) {
		this.documentocomercial = documentocomercial;
	}
	
	public Productotienda getProductotienda() {
		return this.productotienda;
	}

	public void setProductotienda(Productotienda productotienda) {
		this.productotienda = productotienda;
	}
	
	public Repartidor getRepartidor() {
		return this.repartidor;
	}

	public void setRepartidor(Repartidor repartidor) {
		this.repartidor = repartidor;
	}
	
}