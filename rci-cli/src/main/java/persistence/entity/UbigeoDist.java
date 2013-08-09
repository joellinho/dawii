package persistence.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ubigeo_dist database table.
 * 
 */
@Entity
@Table(name="ubigeo_dist")
public class UbigeoDist implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private UbigeoDistPK id;

	@Column(name="udi_nombre")
	private String udiNombre;

	//bi-directional many-to-one association to UbigeoProv
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name="up_cod", referencedColumnName="up_cod", nullable=false, insertable=false, updatable=false),
		@JoinColumn(name="ud_cod", referencedColumnName="ud_cod", nullable=false, insertable=false, updatable=false)
		})
	private UbigeoProv ubigeoProv;

    public UbigeoDist() {
    }

	public UbigeoDistPK getId() {
		return this.id;
	}

	public void setId(UbigeoDistPK id) {
		this.id = id;
	}
	
	public String getUdiNombre() {
		return this.udiNombre;
	}

	public void setUdiNombre(String udiNombre) {
		this.udiNombre = udiNombre;
	}

	public UbigeoProv getUbigeoProv() {
		return this.ubigeoProv;
	}

	public void setUbigeoProv(UbigeoProv ubigeoProv) {
		this.ubigeoProv = ubigeoProv;
	}
	
	// This must return true for another Foo object with same key/id.
    public boolean equals(Object other) {
        return other instanceof UbigeoDist && id!=null ? id.equals( ((UbigeoDist) other).getId() ) : (other == this);
    }

    // This must return the same hashcode for every Foo object with the same key.
    public int hashCode() {
        return id!=null ? this.getClass().hashCode() + id.hashCode() : super.hashCode();
    }
	
}