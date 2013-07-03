package persistence.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the empresa database table.
 * 
 */
@Entity
public class Empresa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String comentarios;

	private String direccion;

	private String email;

    @Lob()
	private byte[] foto;

	private String nombre;

	private String nombrecomercial;

	private String ruc;

	private String telefono;

	private String weburl;

	//bi-directional many-to-one association to Ubigeo
    @ManyToOne
	private Ubigeo ubigeo;

	//bi-directional many-to-one association to Productoempresa
	@OneToMany(mappedBy="empresa")
	private Set<Productoempresa> productoempresas;

	//bi-directional many-to-one association to Tienda
	@OneToMany(mappedBy="empresa")
	private Set<Tienda> tiendas;

    public Empresa() {
    }

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getComentarios() {
		return this.comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
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

	public String getRuc() {
		return this.ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
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
	
	public Set<Productoempresa> getProductoempresas() {
		return this.productoempresas;
	}

	public void setProductoempresas(Set<Productoempresa> productoempresas) {
		this.productoempresas = productoempresas;
	}
	
	public Set<Tienda> getTiendas() {
		return this.tiendas;
	}

	public void setTiendas(Set<Tienda> tiendas) {
		this.tiendas = tiendas;
	}
	
}