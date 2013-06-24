package persistence.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the facturacion database table.
 * 
 */
@Entity
public class Facturacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idfacturacion;

	private BigDecimal bruto;

	private BigDecimal igv;

	private BigDecimal impuesto;

	private BigDecimal neto;

	private BigDecimal tipocambio;

	//bi-directional many-to-one association to Detallepedido
    @ManyToOne
	private Detallepedido detallepedido;

	//bi-directional many-to-one association to Registropedido
    @ManyToOne
	private Registropedido registropedido;

    public Facturacion() {
    }

	public int getIdfacturacion() {
		return this.idfacturacion;
	}

	public void setIdfacturacion(int idfacturacion) {
		this.idfacturacion = idfacturacion;
	}

	public BigDecimal getBruto() {
		return this.bruto;
	}

	public void setBruto(BigDecimal bruto) {
		this.bruto = bruto;
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

	public BigDecimal getNeto() {
		return this.neto;
	}

	public void setNeto(BigDecimal neto) {
		this.neto = neto;
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
	
	public Registropedido getRegistropedido() {
		return this.registropedido;
	}

	public void setRegistropedido(Registropedido registropedido) {
		this.registropedido = registropedido;
	}
	
}