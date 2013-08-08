package persistence.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the ubigeo_prov database table.
 * 
 */
@Embeddable
public class UbigeoProvPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ud_cod")
	private String udCod;

	@Column(name="up_cod")
	private String upCod;

    public UbigeoProvPK() {
    }
	public String getUdCod() {
		return this.udCod;
	}
	public void setUdCod(String udCod) {
		this.udCod = udCod;
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
		if (!(other instanceof UbigeoProvPK)) {
			return false;
		}
		UbigeoProvPK castOther = (UbigeoProvPK)other;
		return 
			this.udCod.equals(castOther.udCod)
			&& this.upCod.equals(castOther.upCod);

    }
    
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.udCod.hashCode();
		hash = hash * prime + this.upCod.hashCode();
		
		return hash;
    }
}