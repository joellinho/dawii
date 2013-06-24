package persistence.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the tipocomprobante database table.
 * 
 */
@Entity
public class Tipocomprobante implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idtipocomprobante;

	private String descripcioncomprobante;

	//bi-directional many-to-one association to Registropedido
	@OneToMany(mappedBy="tipocomprobanteBean")
	private Set<Registropedido> registropedidos;

    public Tipocomprobante() {
    }

	public int getIdtipocomprobante() {
		return this.idtipocomprobante;
	}

	public void setIdtipocomprobante(int idtipocomprobante) {
		this.idtipocomprobante = idtipocomprobante;
	}

	public String getDescripcioncomprobante() {
		return this.descripcioncomprobante;
	}

	public void setDescripcioncomprobante(String descripcioncomprobante) {
		this.descripcioncomprobante = descripcioncomprobante;
	}

	public Set<Registropedido> getRegistropedidos() {
		return this.registropedidos;
	}

	public void setRegistropedidos(Set<Registropedido> registropedidos) {
		this.registropedidos = registropedidos;
	}
	
}