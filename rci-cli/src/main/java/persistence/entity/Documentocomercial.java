package persistence.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the documentocomercial database table.
 * 
 */
@Entity
public class Documentocomercial implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private byte deleted;

	private String direcciondestino;

    @Temporal( TemporalType.TIMESTAMP)
	private Date fechahoraentrada;

    @Temporal( TemporalType.TIMESTAMP)
	private Date fechahorasalida;

	private BigDecimal monto;

	private String observaciones;

	private BigDecimal porcentajeigv;

	private byte ultimopedido;

	//bi-directional many-to-one association to Detallepedido
	@OneToMany(mappedBy="documentocomercial")
	private Set<Detallepedido> detallepedidos;

	//bi-directional many-to-one association to Estadoregistropedido
    @ManyToOne
	private Estadoregistropedido estadoregistropedido;

	//bi-directional many-to-one association to Tienda
    @ManyToOne
	private Tienda tienda;

	//bi-directional many-to-one association to Cliente
    @ManyToOne
	private Cliente cliente;

	//bi-directional many-to-one association to Ubigeo
    @ManyToOne
	private Ubigeo ubigeo;

	//bi-directional many-to-one association to Facturacion
	@OneToMany(mappedBy="documentocomercial")
	private Set<Facturacion> facturacions;

    public Documentocomercial() {
    }

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte getDeleted() {
		return this.deleted;
	}

	public void setDeleted(byte deleted) {
		this.deleted = deleted;
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

	public BigDecimal getMonto() {
		return this.monto;
	}

	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public BigDecimal getPorcentajeigv() {
		return this.porcentajeigv;
	}

	public void setPorcentajeigv(BigDecimal porcentajeigv) {
		this.porcentajeigv = porcentajeigv;
	}

	public byte getUltimopedido() {
		return this.ultimopedido;
	}

	public void setUltimopedido(byte ultimopedido) {
		this.ultimopedido = ultimopedido;
	}

	public Set<Detallepedido> getDetallepedidos() {
		return this.detallepedidos;
	}

	public void setDetallepedidos(Set<Detallepedido> detallepedidos) {
		this.detallepedidos = detallepedidos;
	}
	
	public Estadoregistropedido getEstadoregistropedido() {
		return this.estadoregistropedido;
	}

	public void setEstadoregistropedido(Estadoregistropedido estadoregistropedido) {
		this.estadoregistropedido = estadoregistropedido;
	}
	
	public Tienda getTienda() {
		return this.tienda;
	}

	public void setTienda(Tienda tienda) {
		this.tienda = tienda;
	}
	
	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public Ubigeo getUbigeo() {
		return this.ubigeo;
	}

	public void setUbigeo(Ubigeo ubigeo) {
		this.ubigeo = ubigeo;
	}
	
	public Set<Facturacion> getFacturacions() {
		return this.facturacions;
	}

	public void setFacturacions(Set<Facturacion> facturacions) {
		this.facturacions = facturacions;
	}
	
}