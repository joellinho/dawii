package persistence.entidades;

import javax.persistence.*;

import java.util.*;


/**
 * The persistent class for the distrito database table.
 * 
 */
@Entity
public class Distrito  {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(columnDefinition="INT(11)")
	private int id;
	
	@Column(length=255)
	private String descripcion;

	//bi-directional many-to-one association to Tienda
	@OneToMany(mappedBy="distrito")
	private Collection<Tienda> tiendas = new ArrayList<Tienda>();

	public Collection<Tienda> getTiendas() {
		return tiendas;
	}

	public void setTiendas(Collection<Tienda> tiendas) {
		this.tiendas = tiendas;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}