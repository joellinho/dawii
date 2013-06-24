package persistence.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the tipocliente database table.
 * 
 */
@Entity
public class Tipocliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idtipocliente;

	private String desctipocloente;

	//bi-directional many-to-one association to Cliente
	@OneToMany(mappedBy="tipocliente")
	private Set<Cliente> clientes;

    public Tipocliente() {
    }

	public int getIdtipocliente() {
		return this.idtipocliente;
	}

	public void setIdtipocliente(int idtipocliente) {
		this.idtipocliente = idtipocliente;
	}

	public String getDesctipocloente() {
		return this.desctipocloente;
	}

	public void setDesctipocloente(String desctipocloente) {
		this.desctipocloente = desctipocloente;
	}

	public Set<Cliente> getClientes() {
		return this.clientes;
	}

	public void setClientes(Set<Cliente> clientes) {
		this.clientes = clientes;
	}
	
}