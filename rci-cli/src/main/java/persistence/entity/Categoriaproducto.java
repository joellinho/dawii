package persistence.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the categoriaproducto database table.
 * 
 */
@Entity
public class Categoriaproducto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String descripcion;

	//bi-directional many-to-one association to Productoempresa
	@OneToMany(mappedBy="categoriaproducto")
	private Set<Productoempresa> productoempresas;

    public Categoriaproducto() {
    	
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

	public Set<Productoempresa> getProductoempresas() {
		return this.productoempresas;
	}

	public void setProductoempresas(Set<Productoempresa> productoempresas) {
		this.productoempresas = productoempresas;
	}
	
}