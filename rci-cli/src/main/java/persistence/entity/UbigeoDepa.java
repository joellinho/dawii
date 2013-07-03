package persistence.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the ubigeo_depa database table.
 * 
 */
@Entity
@Table(name="ubigeo_depa")
public class UbigeoDepa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ud_cod")
	private String udCod;

	@Column(name="ud_nombre")
	private String udNombre;

	//bi-directional many-to-one association to UbigeoProv
	@OneToMany(mappedBy="ubigeoDepa")
	private Set<UbigeoProv> ubigeoProvs;

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

	public Set<UbigeoProv> getUbigeoProvs() {
		return this.ubigeoProvs;
	}

	public void setUbigeoProvs(Set<UbigeoProv> ubigeoProvs) {
		this.ubigeoProvs = ubigeoProvs;
	}
	
}