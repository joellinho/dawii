package persistence.entidades;


import javax.persistence.*;


/**
 * The persistent class for the direccion database table.
 * 
 */
@Embeddable
public class Direccion {


	

	@ManyToOne
	private Distrito distrito;

	@Column(length=255)
	private String calle;
	
	@Column(length=255)
	private String numero;

	@Column(length=255)
	private String urbanizacion;

	@Column(length=255)
	private String lote;


	public Distrito getDistrito() {
		return distrito;
	}

	public void setDistrito(Distrito distrito) {
		this.distrito = distrito;
	}

	public String getCalle() {
		return this.calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getLote() {
		return this.lote;
	}

	public void setLote(String lote) {
		this.lote = lote;
	}

	public String getNumero() {
		return this.numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getUrbanizacion() {
		return this.urbanizacion;
	}

	public void setUrbanizacion(String urbanizacion) {
		this.urbanizacion = urbanizacion;
	}

}