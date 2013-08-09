package persistence.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ubigeo_prov database table.
 * 
 */
@Entity
@Table(name="ubigeo_prov")
public class UbigeoProv implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private UbigeoProvPK id;

	@Column(name="up_nombre")
	private String upNombre;

	//bi-directional many-to-one association to UbigeoDist
	@OneToMany(mappedBy="ubigeoProv")
	private List<UbigeoDist> ubigeoDists;

	//bi-directional many-to-one association to UbigeoDepa
 	@ManyToOne(fetch=FetchType.LAZY)
 	//@DescriptionsList
 	@JoinColumn(name="ud_cod", nullable=false, insertable=false, updatable=false)
 	private UbigeoDepa ubigeoDepa;

    public UbigeoProv() {
    }

	public UbigeoProvPK getId() {
		return this.id;
	}

	public void setId(UbigeoProvPK id) {
		this.id = id;
	}
	
	public String getUpNombre() {
		return this.upNombre;
	}

	public void setUpNombre(String upNombre) {
		this.upNombre = upNombre;
	}

	public List<UbigeoDist> getUbigeoDists() {
		return this.ubigeoDists;
	}

	public void setUbigeoDists(List<UbigeoDist> ubigeoDists) {
		this.ubigeoDists = ubigeoDists;
	}
	
	public UbigeoDepa getUbigeoDepa() {
		return this.ubigeoDepa;
	}

	public void setUbigeoDepa(UbigeoDepa ubigeoDepa) {
		this.ubigeoDepa = ubigeoDepa;
	}
	
	// This must return true for another Foo object with same key/id.
    public boolean equals(Object other) {
        return other instanceof UbigeoProv && id!=null ? id.equals( ((UbigeoProv) other).getId() ) : (other == this);
    }

    // This must return the same hashcode for every Foo object with the same key.
    public int hashCode() {
        return id!=null ? this.getClass().hashCode() + id.hashCode() : super.hashCode();
    }
}