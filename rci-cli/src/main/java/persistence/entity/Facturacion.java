package persistence.entity;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the facturacion database table.
 * 
 */
@Entity
public class Facturacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private String deleted;

    @Temporal( TemporalType.TIMESTAMP)
	private Date fechafacturacion;

	private String numerodoc;

	private String observaciones;

	private String razonsocial;

	@Transient
	private int idTiendaTrasient;
	
	//bi-directional many-to-one association to Detallefacturacion
	@OneToMany(mappedBy="facturacion", cascade=CascadeType.PERSIST)
	private List<Detallefacturacion> detallefacturacions;

	//bi-directional many-to-one association to Pedido
    @ManyToOne
	private Pedido pedido;

	//bi-directional many-to-one association to Tipocomprobante
    @ManyToOne
	private Tipocomprobante tipocomprobante;

    public Facturacion() {
    }

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDeleted() {
		return this.deleted;
	}

	public void setDeleted(String deleted) {
		this.deleted = deleted;
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

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getRazonsocial() {
		return this.razonsocial;
	}

	public void setRazonsocial(String razonsocial) {
		this.razonsocial = razonsocial;
	}

	public List<Detallefacturacion> getDetallefacturacions() {
		return this.detallefacturacions;
	}

	public void setDetallefacturacions(List<Detallefacturacion> detallefacturacions) {
		this.detallefacturacions = detallefacturacions;
	}
	
	public Pedido getPedido() {
		return this.pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
	public Tipocomprobante getTipocomprobante() {
		return this.tipocomprobante;
	}

	public void setTipocomprobante(Tipocomprobante tipocomprobante) {
		this.tipocomprobante = tipocomprobante;
	}

	public int getidTiendaTrasient() {
		return idTiendaTrasient;
	}

	public void setidTiendaTrasient(int idTiendaTrasient) {
		this.idTiendaTrasient = idTiendaTrasient;
	}
	
}