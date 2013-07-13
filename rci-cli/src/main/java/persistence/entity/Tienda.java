package persistence.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the tienda database table.
 * 
 */
@Entity
public class Tienda implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String descripcion;

	private String direccion;

	private String nrotelefonofijo;

	private BigDecimal porcimpconsumo;

	//bi-directional many-to-one association to Pedido
	@OneToMany(mappedBy="tienda")
	private List<Pedido> pedidos;

	//bi-directional many-to-one association to Productotienda
	@OneToMany(mappedBy="tienda")
	private List<Productotienda> productotiendas;

	//bi-directional many-to-one association to Repartidor
	@OneToMany(mappedBy="tienda")
	private List<Repartidor> repartidors;

	//bi-directional many-to-one association to Ubigeo
    @ManyToOne
	private Ubigeo ubigeo;

	//bi-directional many-to-one association to Empresacomercial
    @ManyToOne
	private Empresacomercial empresacomercial;

    public Tienda() {
    }

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNrotelefonofijo() {
		return this.nrotelefonofijo;
	}

	public void setNrotelefonofijo(String nrotelefonofijo) {
		this.nrotelefonofijo = nrotelefonofijo;
	}

	public BigDecimal getPorcimpconsumo() {
		return this.porcimpconsumo;
	}

	public void setPorcimpconsumo(BigDecimal porcimpconsumo) {
		this.porcimpconsumo = porcimpconsumo;
	}

	public List<Pedido> getPedidos() {
		return this.pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	
	public List<Productotienda> getProductotiendas() {
		return this.productotiendas;
	}

	public void setProductotiendas(List<Productotienda> productotiendas) {
		this.productotiendas = productotiendas;
	}
	
	public List<Repartidor> getRepartidors() {
		return this.repartidors;
	}

	public void setRepartidors(List<Repartidor> repartidors) {
		this.repartidors = repartidors;
	}
	
	public Ubigeo getUbigeo() {
		return this.ubigeo;
	}

	public void setUbigeo(Ubigeo ubigeo) {
		this.ubigeo = ubigeo;
	}
	
	public Empresacomercial getEmpresacomercial() {
		return this.empresacomercial;
	}

	public void setEmpresacomercial(Empresacomercial empresacomercial) {
		this.empresacomercial = empresacomercial;
	}
	
}