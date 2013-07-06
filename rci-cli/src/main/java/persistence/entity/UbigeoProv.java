package persistence.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the ubigeo_prov database table.
 * 
 */
//@Entity
@Table(name="ubigeo_prov")
public class UbigeoProv implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private UbigeoProvPK id;

	@Column(name="up_nombre")
	private String upNombre;

	//bi-directional many-to-one association to UbigeoDist
	@OneToMany(mappedBy="ubigeoProv")
	private Set<UbigeoDist> ubigeoDists;

	//bi-directional many-to-one association to UbigeoDepa
    @ManyToOne
	@JoinColumn(name="ud_cod", insertable=false, updatable=false)
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

	public Set<UbigeoDist> getUbigeoDists() {
		return this.ubigeoDists;
	}

	public void setUbigeoDists(Set<UbigeoDist> ubigeoDists) {
		this.ubigeoDists = ubigeoDists;
	}
	
	public UbigeoDepa getUbigeoDepa() {
		return this.ubigeoDepa;
	}

	public void setUbigeoDepa(UbigeoDepa ubigeoDepa) {
		this.ubigeoDepa = ubigeoDepa;
	}
	
}