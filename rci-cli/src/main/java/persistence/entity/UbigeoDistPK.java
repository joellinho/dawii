package persistence.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the ubigeo_dist database table.
 * 
 */
//@Embeddable
public class UbigeoDistPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ud_cod")
	private String udCod;

	@Column(name="udi_cod")
	private String udiCod;

	@Column(name="up_cod")
	private String upCod;

    public UbigeoDistPK() {
    }
	public String getUdCod() {
		return this.udCod;
	}
	public void setUdCod(String udCod) {
		this.udCod = udCod;
	}
	public String getUdiCod() {
		return this.udiCod;
	}
	public void setUdiCod(String udiCod) {
		this.udiCod = udiCod;
	}
	public String getUpCod() {
		return this.upCod;
	}
	public void setUpCod(String upCod) {
		this.upCod = upCod;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof UbigeoDistPK)) {
			return false;
		}
		UbigeoDistPK castOther = (UbigeoDistPK)other;
		return 
			this.udCod.equals(castOther.udCod)
			&& this.udiCod.equals(castOther.udiCod)
			&& this.upCod.equals(castOther.upCod);

    }
    
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.udCod.hashCode();
		hash = hash * prime + this.udiCod.hashCode();
		hash = hash * prime + this.upCod.hashCode();
		
		return hash;
    }
}