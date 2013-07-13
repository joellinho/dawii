package persistence.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the generopersona database table.
 * 
 */
@Entity
public class Generopersona implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;

	private String descripcion;

	//bi-directional many-to-one association to Cliente
	@OneToMany(mappedBy="generopersona")
	private List<Cliente> clientes;

	//bi-directional many-to-one association to Repartidor
	@OneToMany(mappedBy="generopersona")
	private List<Repartidor> repartidors;

    public Generopersona() {
    }

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Cliente> getClientes() {
		return this.clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	public List<Repartidor> getRepartidors() {
		return this.repartidors;
	}

	public void setRepartidors(List<Repartidor> repartidors) {
		this.repartidors = repartidors;
	}
	
}