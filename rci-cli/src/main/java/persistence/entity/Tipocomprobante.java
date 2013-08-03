package persistence.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


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
	private List<Facturacion> facturacions;

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

	public List<Facturacion> getFacturacions() {
		return this.facturacions;
	}

	public void setFacturacions(List<Facturacion> facturacions) {
		this.facturacions = facturacions;
	}
	
	// Helpers ------------------------------------------------------------------------------------

    // This must return true for another Foo object with same key/id.
    public boolean equals(Object other) {
        return other instanceof Tipocomprobante && (id >= 0) ? id == (((Tipocomprobante) other).id) : (other == this);
    }

    // This must return the same hashcode for every Foo object with the same key.
    public int hashCode() {
        return id >=0 ? this.getClass().hashCode() + id : super.hashCode();
    }
	
}