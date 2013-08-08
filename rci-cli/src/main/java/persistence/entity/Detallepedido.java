package persistence.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the detallepedido database table.
 * 
 */
@Entity
public class Detallepedido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private int cantidad;

	private BigDecimal ganancia;

	private BigDecimal preciocosto;

	private BigDecimal preciounitario = BigDecimal.ZERO;
	
	//bi-directional many-to-one association to Detallefacturacion
	@OneToMany(mappedBy="detallepedido")
	private List<Detallefacturacion> detallefacturacions;

	//bi-directional many-to-one association to Pedido
    @ManyToOne
	private Pedido pedido;

	//bi-directional many-to-one association to Productotienda
    @ManyToOne
	private Productotienda productotienda;

	//bi-directional many-to-one association to Repartidor
    @ManyToOne
	private Repartidor repartidor;

    public Detallepedido() {
    }

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public BigDecimal getGanancia() {
		return this.ganancia;
	}

	public void setGanancia(BigDecimal ganancia) {
		this.ganancia = ganancia;
	}

	public BigDecimal getPreciocosto() {
		return this.preciocosto;
	}

	public void setPreciocosto(BigDecimal preciocosto) {
		this.preciocosto = preciocosto;
	}

	public BigDecimal getPreciounitario() {
		return this.preciounitario;
	}

	public void setPreciounitario(BigDecimal preciounitario) {
		this.preciounitario = preciounitario;
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
	
	public Productotienda getProductotienda() {
		return this.productotienda;
	}

	public void setProductotienda(Productotienda productotienda) {
		this.productotienda = productotienda;
	}
	
	public Repartidor getRepartidor() {
		return this.repartidor;
	}

	public void setRepartidor(Repartidor repartidor) {
		this.repartidor = repartidor;
	}
	
	// Campos calculados	
	public BigDecimal getPrecioXcantidad(){
		if(preciounitario!=null){
			return this.preciounitario.multiply(new BigDecimal(this.cantidad));
		}
		else{
			return BigDecimal.ZERO;
		}
	}
	
	public BigDecimal getValorImpuestoConsumo(){		
		if(this.getProductotienda()!=null){
			return this.getPrecioXcantidad().multiply( 
					this.getProductotienda().getTienda().getPorcimpconsumo() );
		}
		else{
			return BigDecimal.ZERO;
		}
	}
	
}