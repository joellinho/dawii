package persistence.entity;

import javax.persistence.*;

import java.util.Collection;


/**
 * The persistent class for the ubigeo_depa database table.
 * 
 */
@Entity
@Table(name="ubigeo_depa")
public class UbigeoDepa {

	@Id
	@Column(name="ud_cod", unique=true, nullable=false, length=5)
	private String udcod;

	@Column(name="ud_nombre", length=200)
	private String udnombre;

	//bi-directional many-to-one association to UbigeoProv
	@OneToMany(mappedBy="ubigeodepa")
	private Collection<UbigeoProv> ubigeoprov;

	public String getUdcod() {
		return udcod;
	}

	public void setUdcod(String udcod) {
		this.udcod = udcod;
	}

	public String getUdnombre() {
		return udnombre;
	}

	public void setUdnombre(String udnombre) {
		this.udnombre = udnombre;
	}

	public Collection<UbigeoProv> getUbigeoprov() {
		return ubigeoprov;
	}

	public void setUbigeoprov(Collection<UbigeoProv> ubigeoprov) {
		this.ubigeoprov = ubigeoprov;
	}

	// Helpers ------------------------------------------------------------------------------------

    // This must return true for another Foo object with same key/id.
    public boolean equals(Object other) {
        return other instanceof UbigeoDepa && !(udcod.equals("")) ? udcod.equals( ((UbigeoDepa) other).getUdcod() ) : (other == this);
    }

    // This must return the same hashcode for every Foo object with the same key.
    public int hashCode() {
        return !(udcod.equals("")) ? this.getClass().hashCode() + udcod.hashCode() : super.hashCode();
    }

}