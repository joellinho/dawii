package persistence.entidades;

import javax.persistence.*;

import java.util.*;


/**
 * The persistent class for the empresa database table.
 * 
 */
@Entity
public class Empresa{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(columnDefinition="INT(11)")
	private int id;
	
	@Column(length=50,nullable=false,unique=true)
	private String nombre;

	@Column(length=50,nullable=false,unique=true)
	private String nombrecomercial;

	@Column(length=11,nullable=false,unique=true)
	private String ruc;

	private String direccion;

	private String email;

	private byte[] foto;

	private String telefono;
	
	private String weburl;

	private String comentarios;

	//bi-directional many-to-one association to Tienda
	@OneToMany(mappedBy="empresa", cascade=CascadeType.ALL)
	private Collection<Tienda> tiendas = new ArrayList<Tienda>();

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public Collection<Tienda> getTiendas() {
		return tiendas;
	}

	public void setTiendas(Collection<Tienda> tiendas) {
		this.tiendas = tiendas;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}