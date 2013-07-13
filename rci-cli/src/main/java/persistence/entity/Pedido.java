package persistence.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the pedido database table.
 * 
 */
@Entity
public class Pedido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String deleted;

	private String direcciondestino;

    @Temporal( TemporalType.TIMESTAMP)
	private Date fechahoraentrada;

    @Temporal( TemporalType.TIMESTAMP)
	private Date fechahoraregistro;

    @Temporal( TemporalType.TIMESTAMP)
	private Date fechahorasalida;

	private BigDecimal monto;

	private String observaciones;

	private BigDecimal porcentajeigv;

	private String referenciadirdestino;

	private byte ultimopedido;

	//bi-directional many-to-one association to Detallepedido
	@OneToMany(mappedBy="pedido")
	private List<Detallepedido> detallepedidos;

	//bi-directional many-to-one association to Facturacion
	@OneToMany(mappedBy="pedido")
	private List<Facturacion> facturacions;

	//bi-directional many-to-one association to Tienda
    @ManyToOne
	private Tienda tienda;

	//bi-directional many-to-one association to Estadopedido
    @ManyToOne
	private Estadopedido estadopedido;

	//bi-directional many-to-one association to Cliente
    @ManyToOne
	private Cliente cliente;

    public Pedido() {
    }

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDeleted() {
		return this.deleted;
	}

	public void setDeleted(String deleted) {
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

	public Date getFechahoraregistro() {
		return this.fechahoraregistro;
	}

	public void setFechahoraregistro(Date fechahoraregistro) {
		this.fechahoraregistro = fechahoraregistro;
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

	public String getReferenciadirdestino() {
		return this.referenciadirdestino;
	}

	public void setReferenciadirdestino(String referenciadirdestino) {
		this.referenciadirdestino = referenciadirdestino;
	}

	public byte getUltimopedido() {
		return this.ultimopedido;
	}

	public void setUltimopedido(byte ultimopedido) {
		this.ultimopedido = ultimopedido;
	}

	public List<Detallepedido> getDetallepedidos() {
		return this.detallepedidos;
	}

	public void setDetallepedidos(List<Detallepedido> detallepedidos) {
		this.detallepedidos = detallepedidos;
	}
	
	public List<Facturacion> getFacturacions() {
		return this.facturacions;
	}

	public void setFacturacions(List<Facturacion> facturacions) {
		this.facturacions = facturacions;
	}
	
	public Tienda getTienda() {
		return this.tienda;
	}

	public void setTienda(Tienda tienda) {
		this.tienda = tienda;
	}
	
	public Estadopedido getEstadopedido() {
		return this.estadopedido;
	}

	public void setEstadopedido(Estadopedido estadopedido) {
		this.estadopedido = estadopedido;
	}
	
	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
}