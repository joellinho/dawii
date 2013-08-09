package persistence.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ubigeo_depa database table.
 * 
 */
@Entity
@Table(name="ubigeo_depa")
public class UbigeoDepa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ud_cod")
	private String udCod;

	@Column(name="ud_nombre")
	private String udNombre;

	//bi-directional many-to-one association to UbigeoProv
	@OneToMany(mappedBy="ubigeoDepa")
	private List<UbigeoProv> ubigeoProvs;

    public UbigeoDepa() {
    }

	public String getUdCod() {
		return this.udCod;
	}

	public void setUdCod(String udCod) {
		this.udCod = udCod;
	}

	public String getUdNombre() {
		return this.udNombre;
	}

	public void setUdNombre(String udNombre) {
		this.udNombre = udNombre;
	}

	public List<UbigeoProv> getUbigeoProvs() {
		return this.ubigeoProvs;
	}

	public void setUbigeoProvs(List<UbigeoProv> ubigeoProvs) {
		this.ubigeoProvs = ubigeoProvs;
	}
	
	// Helpers ------------------------------------------------------------------------------------

    // This must return true for another Foo object with same key/id.
    public boolean equals(Object other) {
        return other instanceof UbigeoDepa && !(udCod.equals("")) ? udCod.equals( ((UbigeoDepa) other).getUdCod() ) : (other == this);
    }

    // This must return the same hashcode for every Foo object with the same key.
    public int hashCode() {
        return !(udCod.equals("")) ? this.getClass().hashCode() + udCod.hashCode() : super.hashCode();
    }

}