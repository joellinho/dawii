package persistence.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the empresacomercial database table.
 * 
 */
@Entity
public class Empresacomercial implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String direccion;

	private String email;

    @Lob()
	private byte[] foto;

	private String nombre;

	private String nombrecomercial;

	private String nrotelefonofijo;

	private String observaciones;

	private BigDecimal porcimpconsumo;

	private String ruc;

	private String weburl;

	//bi-directional many-to-one association to Ubigeo
    @ManyToOne
	private Ubigeo ubigeo;

	//bi-directional many-to-one association to Productoempresa
	@OneToMany(mappedBy="empresacomercial", fetch= FetchType.EAGER)
	private List<Productoempresa> productoempresas;

	//bi-directional many-to-one association to Tienda
	@OneToMany(mappedBy="empresacomercial")
	private List<Tienda> tiendas;

    public Empresacomercial() {
    }

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public byte[] getFoto() {
		return this.foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombrecomercial() {
		return this.nombrecomercial;
	}

	public void setNombrecomercial(String nombrecomercial) {
		this.nombrecomercial = nombrecomercial;
	}

	public String getNrotelefonofijo() {
		return this.nrotelefonofijo;
	}

	public void setNrotelefonofijo(String nrotelefonofijo) {
		this.nrotelefonofijo = nrotelefonofijo;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public BigDecimal getPorcimpconsumo() {
		return this.porcimpconsumo;
	}

	public void setPorcimpconsumo(BigDecimal porcimpconsumo) {
		this.porcimpconsumo = porcimpconsumo;
	}

	public String getRuc() {
		return this.ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public String getWeburl() {
		return this.weburl;
	}

	public void setWeburl(String weburl) {
		this.weburl = weburl;
	}

	public Ubigeo getUbigeo() {
		return this.ubigeo;
	}

	public void setUbigeo(Ubigeo ubigeo) {
		this.ubigeo = ubigeo;
	}
	
	public List<Productoempresa> getProductoempresas() {
		return this.productoempresas;
	}

	public void setProductoempresas(List<Productoempresa> productoempresas) {
		this.productoempresas = productoempresas;
	}
	
	public List<Tienda> getTiendas() {
		return this.tiendas;
	}

	public void setTiendas(List<Tienda> tiendas) {
		this.tiendas = tiendas;
	}
	
}