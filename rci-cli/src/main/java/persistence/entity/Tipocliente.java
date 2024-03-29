package persistence.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipocliente database table.
 * 
 */
@Entity
public class Tipocliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String descripcion;

	//bi-directional many-to-one association to Cliente
	@OneToMany(mappedBy="tipocliente")
	private List<Cliente> clientes;

    public Tipocliente() {
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
	
}