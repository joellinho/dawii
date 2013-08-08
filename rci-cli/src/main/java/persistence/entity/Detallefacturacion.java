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
	@Column(name="detalleorden_id")
	private int detalleordenId;

	private BigDecimal bruto;

	private int cantidad;

	private BigDecimal impuestoconsumo;

	private BigDecimal impuestoigv;

	private BigDecimal neto;

	private BigDecimal porcentajeigv;

	private BigDecimal porcentajeimpuestoconsumo;

	private BigDecimal tipocambio;

	//bi-directional many-to-one association to Detallepedido
    @ManyToOne
	private Detallepedido detallepedido;

	//bi-directional many-to-one association to Facturacion
    @ManyToOne
	private Facturacion facturacion;

	//bi-directional many-to-one association to Productotienda
    @ManyToOne
	private Productotienda productotienda;

    public Detallefacturacion() {
    }

	public int getDetalleordenId() {
		return this.detalleordenId;
	}

	public void setDetalleordenId(int detalleordenId) {
		this.detalleordenId = detalleordenId;
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

	public BigDecimal getImpuestoconsumo() {
		return this.impuestoconsumo;
	}

	public void setImpuestoconsumo(BigDecimal impuestoconsumo) {
		this.impuestoconsumo = impuestoconsumo;
	}

	public BigDecimal getImpuestoigv() {
		return this.impuestoigv;
	}

	public void setImpuestoigv(BigDecimal impuestoigv) {
		this.impuestoigv = impuestoigv;
	}

	public BigDecimal getNeto() {
		return this.neto;
	}

	public void setNeto(BigDecimal neto) {
		this.neto = neto;
	}

	public BigDecimal getPorcentajeigv() {
		return this.porcentajeigv;
	}

	public void setPorcentajeigv(BigDecimal porcentajeigv) {
		this.porcentajeigv = porcentajeigv;
	}

	public BigDecimal getPorcentajeimpuestoconsumo() {
		return this.porcentajeimpuestoconsumo;
	}

	public void setPorcentajeimpuestoconsumo(BigDecimal porcentajeimpuestoconsumo) {
		this.porcentajeimpuestoconsumo = porcentajeimpuestoconsumo;
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