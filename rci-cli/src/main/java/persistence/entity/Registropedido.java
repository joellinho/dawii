package persistence.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the registropedido database table.
 * 
 */
@Entity
public class Registropedido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idPedido;

	private String direcciondestino;

    @Temporal( TemporalType.TIMESTAMP)
	private Date fechahoraentrada;

    @Temporal( TemporalType.TIMESTAMP)
	private Date fechahorasalida;

	private String numerodocumentoid;

    @Lob()
	private String observaciones;

	private String razonsocial;

	private int tipocomprobante;

	private String ultimopedido;

	//bi-directional many-to-one association to Detallepedido
	@OneToMany(mappedBy="registropedido")
	private Set<Detallepedido> detallepedidos;

	//bi-directional many-to-one association to Facturacion
	@OneToMany(mappedBy="registropedido")
	private Set<Facturacion> facturacions;

	//bi-directional many-to-one association to Cliente
    @ManyToOne
	@JoinColumn(name="clientes_idclientes")
	private Cliente cliente;

	//bi-directional many-to-one association to Estado
    @ManyToOne
	@JoinColumn(name="estados_idestados")
	private Estado estado;

	//bi-directional many-to-one association to Tipocomprobante
    @ManyToOne
	@JoinColumn(name="tipocomprobante_idtipocomprobante")
	private Tipocomprobante tipocomprobanteBean;

	//bi-directional many-to-one association to Ubigeo
    @ManyToOne
	private Ubigeo ubigeo;

    public Registropedido() {
    }

	public int getIdPedido() {
		return this.idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public String getDirecciondestino() {
		return this.direcciondestino;
	}

	public void setDirecciondestino(String direcciondestino) {
		this.direcciondestino = direcciondestino;
	}

	public Date getFechahoraentrada() {
		return this.fechahoraentrada;
	}

	public void setFechahoraentrada(Date fechahoraentrada) {
		this.fechahoraentrada = fechahoraentrada;
	}

	public Date getFechahorasalida() {
		return this.fechahorasalida;
	}

	public void setFechahorasalida(Date fechahorasalida) {
		this.fechahorasalida = fechahorasalida;
	}

	public String getNumerodocumentoid() {
		return this.numerodocumentoid;
	}

	public void setNumerodocumentoid(String numerodocumentoid) {
		this.numerodocumentoid = numerodocumentoid;
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

	public int getTipocomprobante() {
		return this.tipocomprobante;
	}

	public void setTipocomprobante(int tipocomprobante) {
		this.tipocomprobante = tipocomprobante;
	}

	public String getUltimopedido() {
		return this.ultimopedido;
	}

	public void setUltimopedido(String ultimopedido) {
		this.ultimopedido = ultimopedido;
	}

	public Set<Detallepedido> getDetallepedidos() {
		return this.detallepedidos;
	}

	public void setDetallepedidos(Set<Detallepedido> detallepedidos) {
		this.detallepedidos = detallepedidos;
	}
	
	public Set<Facturacion> getFacturacions() {
		return this.facturacions;
	}

	public void setFacturacions(Set<Facturacion> facturacions) {
		this.facturacions = facturacions;
	}
	
	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public Estado getEstado() {
		return this.estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	public Tipocomprobante getTipocomprobanteBean() {
		return this.tipocomprobanteBean;
	}

	public void setTipocomprobanteBean(Tipocomprobante tipocomprobanteBean) {
		this.tipocomprobanteBean = tipocomprobanteBean;
	}
	
	public Ubigeo getUbigeo() {
		return this.ubigeo;
	}

	public void setUbigeo(Ubigeo ubigeo) {
		this.ubigeo = ubigeo;
	}
	
}