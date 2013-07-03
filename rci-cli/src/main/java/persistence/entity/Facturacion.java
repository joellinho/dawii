package persistence.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the facturacion database table.
 * 
 */
@Entity
public class Facturacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

    @Temporal( TemporalType.TIMESTAMP)
	private Date fechafacturacion;

	private String numerodoc;

	private String razonsocial;

	//bi-directional many-to-one association to Detallefacturacion
	@OneToMany(mappedBy="facturacion")
	private Set<Detallefacturacion> detallefacturacions;

	//bi-directional many-to-one association to Documentocomercial
    @ManyToOne
	private Documentocomercial documentocomercial;

	//bi-directional many-to-one association to Tipocomprobante
    @ManyToOne
	private Tipocomprobante tipocomprobante;

    public Facturacion() {
    }

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFechafacturacion() {
		return this.fechafacturacion;
	}

	public void setFechafacturacion(Date fechafacturacion) {
		this.fechafacturacion = fechafacturacion;
	}

	public String getNumerodoc() {
		return this.numerodoc;
	}

	public void setNumerodoc(String numerodoc) {
		this.numerodoc = numerodoc;
	}

	public String getRazonsocial() {
		return this.razonsocial;
	}

	public void setRazonsocial(String razonsocial) {
		this.razonsocial = razonsocial;
	}

	public Set<Detallefacturacion> getDetallefacturacions() {
		return this.detallefacturacions;
	}

	public void setDetallefacturacions(Set<Detallefacturacion> detallefacturacions) {
		this.detallefacturacions = detallefacturacions;
	}
	
	public Documentocomercial getDocumentocomercial() {
		return this.documentocomercial;
	}

	public void setDocumentocomercial(Documentocomercial documentocomercial) {
		this.documentocomercial = documentocomercial;
	}
	
	public Tipocomprobante getTipocomprobante() {
		return this.tipocomprobante;
	}

	public void setTipocomprobante(Tipocomprobante tipocomprobante) {
		this.tipocomprobante = tipocomprobante;
	}
	
}