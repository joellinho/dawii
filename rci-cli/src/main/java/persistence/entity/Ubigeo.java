package persistence.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ubigeo database table.
 * 
 */
@Entity
public class Ubigeo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="cod_dep")
	private String codDep;

	@Column(name="cod_dis")
	private String codDis;

	@Column(name="cod_pais")
	private String codPais;

	@Column(name="cod_pro")
	private String codPro;

	@Column(name="nom_dep")
	private String nomDep;

	@Column(name="nom_dist")
	private String nomDist;

	@Column(name="nom_pais")
	private String nomPais;

	@Column(name="nom_prov")
	private String nomProv;

	//bi-directional many-to-one association to Cliente
	@OneToMany(mappedBy="ubigeo")
	private List<Cliente> clientes;

	//bi-directional many-to-one association to Empresacomercial
	@OneToMany(mappedBy="ubigeo")
	private List<Empresacomercial> empresacomercials;

	//bi-directional many-to-one association to Repartidor
	@OneToMany(mappedBy="ubigeo")
	private List<Repartidor> repartidors;

	//bi-directional many-to-one association to Tienda
	@OneToMany(mappedBy="ubigeo")
	private List<Tienda> tiendas;

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

	public String getCodPais() {
		return this.codPais;
	}

	public void setCodPais(String codPais) {
		this.codPais = codPais;
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

	public String getNomPais() {
		return this.nomPais;
	}

	public void setNomPais(String nomPais) {
		this.nomPais = nomPais;
	}

	public String getNomProv() {
		return this.nomProv;
	}

	public void setNomProv(String nomProv) {
		this.nomProv = nomProv;
	}

	public List<Cliente> getClientes() {
		return this.clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	public List<Empresacomercial> getEmpresacomercials() {
		return this.empresacomercials;
	}

	public void setEmpresacomercials(List<Empresacomercial> empresacomercials) {
		this.empresacomercials = empresacomercials;
	}
	
	public List<Repartidor> getRepartidors() {
		return this.repartidors;
	}

	public void setRepartidors(List<Repartidor> repartidors) {
		this.repartidors = repartidors;
	}
	
	public List<Tienda> getTiendas() {
		return this.tiendas;
	}

	public void setTiendas(List<Tienda> tiendas) {
		this.tiendas = tiendas;
	}
	
	public String toString(){
		return this.getCodPais() + 
				this.getCodDep() +
				this.getCodDis() +
				this.getCodPro();
	}
	
}