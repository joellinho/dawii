package persistence.entidades;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.*;



@Entity
public class Pedido {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(columnDefinition="INT(11)")
	private int id;

	private Date fechahoraentrada;

	private Date fechahorasalida;

	// bi-directional many-to-one association to Tienda
	@ManyToOne(fetch = FetchType.LAZY)
	private Tienda tienda;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	private Cliente cliente;

	private BigDecimal porcentajeigv;

	// bi-directional many-to-one association to Detallepedido
	@OneToMany(fetch = FetchType.EAGER, mappedBy="pedido")
	private List<DetallePedido> detallepedidos;

	private String observaciones;

	// bi-directional many-to-one association to Estadoregistropedido
	@ManyToOne(fetch = FetchType.LAZY)
	private EstadoRegistroPedido estadoRegistroPedido;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BigDecimal getPorcentajeigv() {
		if (porcentajeigv == null) {
			return BigDecimal.ZERO;
		}
		return porcentajeigv;
	}

	public void setPorcentajeigv(BigDecimal porcentajeigv) {
		this.porcentajeigv = porcentajeigv;
	}

	public List<DetallePedido> getDetallepedidos() {
		return detallepedidos;
	}

	public void setDetallepedidos(List<DetallePedido> detallepedidos) {
		this.detallepedidos = detallepedidos;
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

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Tienda getTienda() {
		return this.tienda;
	}

	public void setTienda(Tienda tienda) {
		this.tienda = tienda;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public EstadoRegistroPedido getEstadoRegistroPedido() {
		return this.estadoRegistroPedido;
	}

	public void setEstadoRegistroPedido(
			EstadoRegistroPedido estadoRegistroPedido) {
		this.estadoRegistroPedido = estadoRegistroPedido;
	}

	// MONTOS CALCULADOS

	// Monto base
	public BigDecimal getMontoBase() {
		BigDecimal resultado = new BigDecimal("0.00");
		for (DetallePedido detalle : getDetallepedidos()) {
			resultado = resultado.add(detalle.getImporte());
		}
		return resultado;
	}

	// IGV
	public BigDecimal getIgv() {
		return getMontoBase().multiply(getPorcentajeigv()).divide(
				new BigDecimal("100"));
	}

	// TOTAL
	public BigDecimal getMontoTotal() {
		return getMontoBase().add(getIgv());
	}


}