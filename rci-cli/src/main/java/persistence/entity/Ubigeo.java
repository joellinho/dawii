package persistence.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the ubigeo database table.
 * 
 */
@Entity
public class Ubigeo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="cod_dep")
	private String codDep;

	@Column(name="cod_dis")
	private String codDis;

	@Column(name="cod_pro")
	private String codPro;

	@Column(name="nom_dep")
	private String nomDep;

	@Column(name="nom_dist")
	private String nomDist;

	@Column(name="nom_prov")
	private String nomProv;

	//bi-directional many-to-one association to Cliente
	@OneToMany(mappedBy="ubigeo")
	private Set<Cliente> clientes;

	//bi-directional many-to-one association to Documentocomercial
	@OneToMany(mappedBy="ubigeo")
	private Set<Documentocomercial> documentocomercials;

	//bi-directional many-to-one association to Empresa
	@OneToMany(mappedBy="ubigeo")
	private Set<Empresa> empresas;

	//bi-directional many-to-one association to Repartidor
	@OneToMany(mappedBy="ubigeo")
	private Set<Repartidor> repartidors;

	//bi-directional many-to-one association to Tienda
	@OneToMany(mappedBy="ubigeo")
	private Set<Tienda> tiendas;

    public Ubigeo() {
    }

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodDep() {
		return this.codDep;
	}

	public void setCodDep(String codDep) {
		this.codDep = codDep;
	}

	public String getCodDis() {
		return this.codDis;
	}

	public void setCodDis(String codDis) {
		this.codDis = codDis;
	}

	public String getCodPro() {
		return this.codPro;
	}

	public void setCodPro(String codPro) {
		this.codPro = codPro;
	}

	public String getNomDep() {
		return this.nomDep;
	}

	public void setNomDep(String nomDep) {
		this.nomDep = nomDep;
	}

	public String getNomDist() {
		return this.nomDist;
	}

	public void setNomDist(String nomDist) {
		this.nomDist = nomDist;
	}

	public String getNomProv() {
		return this.nomProv;
	}

	public void setNomProv(String nomProv) {
		this.nomProv = nomProv;
	}

	public Set<Cliente> getClientes() {
		return this.clientes;
	}

	public void setClientes(Set<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	public Set<Documentocomercial> getDocumentocomercials() {
		return this.documentocomercials;
	}

	public void setDocumentocomercials(Set<Documentocomercial> documentocomercials) {
		this.documentocomercials = documentocomercials;
	}
	
	public Set<Empresa> getEmpresas() {
		return this.empresas;
	}

	public void setEmpresas(Set<Empresa> empresas) {
		this.empresas = empresas;
	}
	
	public Set<Repartidor> getRepartidors() {
		return this.repartidors;
	}

	public void setRepartidors(Set<Repartidor> repartidors) {
		this.repartidors = repartidors;
	}
	
	public Set<Tienda> getTiendas() {
		return this.tiendas;
	}

	public void setTiendas(Set<Tienda> tiendas) {
		this.tiendas = tiendas;
	}
	
}