package persistence.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the estados database table.
 * 
 */
@Entity
@Table(name="estados")
public class Estado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idestados;

	private String descestados;

	//bi-directional many-to-one association to Registropedido
	@OneToMany(mappedBy="estado")
	private Set<Registropedido> registropedidos;

    public Estado() {
    }

	public int getIdestados() {
		return this.idestados;
	}

	public void setIdestados(int idestados) {
		this.idestados = idestados;
	}

	public String getDescestados() {
		return this.descestados;
	}

	public void setDescestados(String descestados) {
		this.descestados = descestados;
	}

	public Set<Registropedido> getRegistropedidos() {
		return this.registropedidos;
	}

	public void setRegistropedidos(Set<Registropedido> registropedidos) {
		this.registropedidos = registropedidos;
	}
	
}