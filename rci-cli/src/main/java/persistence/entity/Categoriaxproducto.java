package persistence.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the categoriaxproducto database table.
 * 
 */
@Entity
public class Categoriaxproducto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idcategoria;

	private String descategoria;

	//bi-directional many-to-one association to Productoxempresa
	@OneToMany(mappedBy="categoriaxproducto")
	private Set<Productoxempresa> productoxempresas;

    public Categoriaxproducto() {
    }

	public int getIdcategoria() {
		return this.idcategoria;
	}

	public void setIdcategoria(int idcategoria) {
		this.idcategoria = idcategoria;
	}

	public String getDescategoria() {
		return this.descategoria;
	}

	public void setDescategoria(String descategoria) {
		this.descategoria = descategoria;
	}

	public Set<Productoxempresa> getProductoxempresas() {
		return this.productoxempresas;
	}

	public void setProductoxempresas(Set<Productoxempresa> productoxempresas) {
		this.productoxempresas = productoxempresas;
	}
	
}