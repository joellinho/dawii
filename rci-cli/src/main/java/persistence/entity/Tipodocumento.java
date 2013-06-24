package persistence.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the tipodocumento database table.
 * 
 */
@Entity
public class Tipodocumento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idtipodocumento;

	private String descripciontipodocumento;

	//bi-directional many-to-one association to Cliente
	@OneToMany(mappedBy="tipodocumento")
	private Set<Cliente> clientes;

    public Tipodocumento() {
    }

	public int getIdtipodocumento() {
		return this.idtipodocumento;
	}

	public void setIdtipodocumento(int idtipodocumento) {
		this.idtipodocumento = idtipodocumento;
	}

	public String getDescripciontipodocumento() {
		return this.descripciontipodocumento;
	}

	public void setDescripciontipodocumento(String descripciontipodocumento) {
		this.descripciontipodocumento = descripciontipodocumento;
	}

	public Set<Cliente> getClientes() {
		return this.clientes;
	}

	public void setClientes(Set<Cliente> clientes) {
		this.clientes = clientes;
	}
	
}