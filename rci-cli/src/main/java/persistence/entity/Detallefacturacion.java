package persistence.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the detallefacturacion database table.
 * 
 */
@Entity
public class Detallefacturacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="detallepedido_id")
	private int detallepedidoId;

	private BigDecimal bruto;

	private int cantidad;

	private BigDecimal igv;

	private BigDecimal impuesto;

	private BigDecimal tipocambio;

	//bi-directional one-to-one association to Detallepedido
	@OneToOne
	private Detallepedido detallepedido;

	//bi-directional many-to-one association to Facturacion
    @ManyToOne
	private Facturacion facturacion;

	//bi-directional many-to-one association to Productotienda
    @ManyToOne
	private Productotienda productotienda;

    public Detallefacturacion() {
    }

	public int getDetallepedidoId() {
		return this.detallepedidoId;
	}

	public void setDetallepedidoId(int detallepedidoId) {
		this.detallepedidoId = detallepedidoId;
	}

	public BigDecimal getBruto() {
		return this.bruto;
	}

	public void setBruto(BigDecimal bruto) {
		this.bruto = bruto;
	}

	public int getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public BigDecimal getIgv() {
		return this.igv;
	}

	public void setIgv(BigDecimal igv) {
		this.igv = igv;
	}

	public BigDecimal getImpuesto() {
		return this.impuesto;
	}

	public void setImpuesto(BigDecimal impuesto) {
		this.impuesto = impuesto;
	}

	public BigDecimal getTipocambio() {
		return this.tipocambio;
	}

	public void setTipocambio(BigDecimal tipocambio) {
		this.tipocambio = tipocambio;
	}

	public Detallepedido getDetallepedido() {
		return this.detallepedido;
	}

	public void setDetallepedido(Detallepedido detallepedido) {
		this.detallepedido = detallepedido;
	}
	
	public Facturacion getFacturacion() {
		return this.facturacion;
	}

	public void setFacturacion(Facturacion facturacion) {
		this.facturacion = facturacion;
	}
	
	public Productotienda getProductotienda() {
		return this.productotienda;
	}

	public void setProductotienda(Productotienda productotienda) {
		this.productotienda = productotienda;
	}
	
}