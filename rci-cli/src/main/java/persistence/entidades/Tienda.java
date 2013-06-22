package persistence.entidades;

import javax.persistence.*;

import java.util.*;


/**
 * The persistent class for the tienda database table.
 * 
 */
@Entity
public class Tienda  {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(columnDefinition="INT(11)")
	private int id;
	
	
	@Column(length=50,nullable=false,unique=true)
	private String descripcion;

	//bi-directional many-to-one association to Distrito
	@ManyToOne(fetch=FetchType.LAZY)
	private Distrito distrito;

	@Column(length=50,nullable=false)
	private String calle;

	private String telefono;

	//bi-directional many-to-one association to Productotienda
	@OneToMany(mappedBy="tienda", cascade=CascadeType.ALL)
	private Collection<ProductoTienda> productotiendas = new ArrayList<ProductoTienda>();

	//bi-directional many-to-one association to Repartidor
	@OneToMany(mappedBy="tienda", cascade=CascadeType.ALL)
	private Collection<Repartidor> repartidores = new ArrayList<Repartidor>();

	//bi-directional many-to-one association to Pedido
	@OneToMany(mappedBy="tienda", cascade=CascadeType.ALL)
	private Collection<Pedido> pedidos=new ArrayList<Pedido>();

	//bi-directional many-to-one association to Empresa
	@ManyToOne(fetch=FetchType.LAZY)
	private Empresa empresa;

	public Collection<ProductoTienda> getProductotiendas() {
		return productotiendas;
	}

	public void setProductotiendas(Collection<ProductoTienda> productotiendas) {
		this.productotiendas = productotiendas;
	}

	public Collection<Repartidor> getRepartidores() {
		return repartidores;
	}

	public void setRepartidores(Collection<Repartidor> repartidores) {
		this.repartidores = repartidores;
	}

	public Collection<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(Collection<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public String getCalle() {
		return this.calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Distrito getDistrito() {
		return this.distrito;
	}

	public void setDistrito(Distrito distrito) {
		this.distrito = distrito;
	}

	public Empresa getEmpresa() {
		return this.empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}