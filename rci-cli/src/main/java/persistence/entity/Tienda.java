package persistence.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


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

	private String telefono;

	//bi-directional many-to-one association to Documentocomercial
	@OneToMany(mappedBy="tienda")
	private Set<Documentocomercial> documentocomercials;

	//bi-directional many-to-one association to Productotienda
	@OneToMany(mappedBy="tienda")
	private Set<Productotienda> productotiendas;

	//bi-directional many-to-one association to Repartidor
	@OneToMany(mappedBy="tienda")
	private Set<Repartidor> repartidors;

	//bi-directional many-to-one association to Empresa
    @ManyToOne
	private Empresa empresa;

	//bi-directional many-to-one association to Ubigeo
    @ManyToOne
	private Ubigeo ubigeo;

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

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Set<Documentocomercial> getDocumentocomercials() {
		return this.documentocomercials;
	}

	public void setDocumentocomercials(Set<Documentocomercial> documentocomercials) {
		this.documentocomercials = documentocomercials;
	}
	
	public Set<Productotienda> getProductotiendas() {
		return this.productotiendas;
	}

	public void setProductotiendas(Set<Productotienda> productotiendas) {
		this.productotiendas = productotiendas;
	}
	
	public Set<Repartidor> getRepartidors() {
		return this.repartidors;
	}

	public void setRepartidors(Set<Repartidor> repartidors) {
		this.repartidors = repartidors;
	}
	
	public Empresa getEmpresa() {
		return this.empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
	public Ubigeo getUbigeo() {
		return this.ubigeo;
	}

	public void setUbigeo(Ubigeo ubigeo) {
		this.ubigeo = ubigeo;
	}
	
}