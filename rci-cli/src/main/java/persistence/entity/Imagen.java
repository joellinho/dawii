package persistence.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the imagen database table.
 * 
 */
@Entity
public class Imagen implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idimagen;

	private String nombreimagen;

	private String urlimagen;

	//bi-directional many-to-one association to Empresa
	@OneToMany(mappedBy="imagen")
	private Set<Empresa> empresas;

	//bi-directional many-to-one association to Productoxempresa
	@OneToMany(mappedBy="imagen")
	private Set<Productoxempresa> productoxempresas;

    public Imagen() {
    }

	public int getIdimagen() {
		return this.idimagen;
	}

	public void setIdimagen(int idimagen) {
		this.idimagen = idimagen;
	}

	public String getNombreimagen() {
		return this.nombreimagen;
	}

	public void setNombreimagen(String nombreimagen) {
		this.nombreimagen = nombreimagen;
	}

	public String getUrlimagen() {
		return this.urlimagen;
	}

	public void setUrlimagen(String urlimagen) {
		this.urlimagen = urlimagen;
	}

	public Set<Empresa> getEmpresas() {
		return this.empresas;
	}

	public void setEmpresas(Set<Empresa> empresas) {
		this.empresas = empresas;
	}
	
	public Set<Productoxempresa> getProductoxempresas() {
		return this.productoxempresas;
	}

	public void setProductoxempresas(Set<Productoxempresa> productoxempresas) {
		this.productoxempresas = productoxempresas;
	}
	
}