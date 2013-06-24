package persistence.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the ubigeo database table.
 * 
 */
@Entity
public class Ubigeo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idubigeo;

	private String desubigeo;

	//bi-directional many-to-one association to Cliente
	@OneToMany(mappedBy="ubigeo")
	private Set<Cliente> clientes;

	//bi-directional many-to-one association to Registropedido
	@OneToMany(mappedBy="ubigeo")
	private Set<Registropedido> registropedidos;

	//bi-directional many-to-one association to Ciudad
    @ManyToOne
	private Ciudad ciudad;

    public Ubigeo() {
    }

	public int getIdubigeo() {
		return this.idubigeo;
	}

	public void setIdubigeo(int idubigeo) {
		this.idubigeo = idubigeo;
	}

	public String getDesubigeo() {
		return this.desubigeo;
	}

	public void setDesubigeo(String desubigeo) {
		this.desubigeo = desubigeo;
	}

	public Set<Cliente> getClientes() {
		return this.clientes;
	}

	public void setClientes(Set<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	public Set<Registropedido> getRegistropedidos() {
		return this.registropedidos;
	}

	public void setRegistropedidos(Set<Registropedido> registropedidos) {
		this.registropedidos = registropedidos;
	}
	
	public Ciudad getCiudad() {
		return this.ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}
	
}