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
	private int id;

	private String descripcion;

	//bi-directional many-to-one association to Cliente
	@OneToMany(mappedBy="generopersona")
	private List<Cliente> clientes;

	//bi-directional many-to-one association to Repartidor
	@OneToMany(mappedBy="generopersona")
	private List<Repartidor> repartidors;

    public Generopersona() {
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
	
	// Helpers ------------------------------------------------------------------------------------

    // This must return true for another Foo object with same key/id.
    public boolean equals(Object other) {
        return other instanceof Generopersona && (id >= 0) ? id == (((Generopersona) other).id) : (other == this);
    }

    // This must return the same hashcode for every Foo object with the same key.
    public int hashCode() {
        return id >=0 ? this.getClass().hashCode() + id : super.hashCode();
    }

	
}