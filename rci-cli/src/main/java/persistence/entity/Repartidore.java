package persistence.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the repartidores database table.
 * 
 */
@Entity
@Table(name="repartidores")
public class Repartidore implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idrepartidores;

	private String descrepartidor;

	private int idEmpresa;

	private int idTienda;

	//bi-directional many-to-one association to Detallepedido
	@OneToMany(mappedBy="repartidore")
	private Set<Detallepedido> detallepedidos;

    public Repartidore() {
    }

	public int getIdrepartidores() {
		return this.idrepartidores;
	}

	public void setIdrepartidores(int idrepartidores) {
		this.idrepartidores = idrepartidores;
	}

	public String getDescrepartidor() {
		return this.descrepartidor;
	}

	public void setDescrepartidor(String descrepartidor) {
		this.descrepartidor = descrepartidor;
	}

	public int getIdEmpresa() {
		return this.idEmpresa;
	}

	public void setIdEmpresa(int idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public int getIdTienda() {
		return this.idTienda;
	}

	public void setIdTienda(int idTienda) {
		this.idTienda = idTienda;
	}

	public Set<Detallepedido> getDetallepedidos() {
		return this.detallepedidos;
	}

	public void setDetallepedidos(Set<Detallepedido> detallepedidos) {
		this.detallepedidos = detallepedidos;
	}
	
}