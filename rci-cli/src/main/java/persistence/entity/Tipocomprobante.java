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
	private int id;

	private String descripcion;

	//bi-directional many-to-one association to Facturacion
	@OneToMany(mappedBy="tipocomprobante")
	private Set<Facturacion> facturacions;

    public Tipocomprobante() {
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

	public Set<Facturacion> getFacturacions() {
		return this.facturacions;
	}

	public void setFacturacions(Set<Facturacion> facturacions) {
		this.facturacions = facturacions;
	}
	
}