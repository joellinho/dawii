package persistence.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the ciudad database table.
 * 
 */
@Entity
public class Ciudad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCiudad;

	private String descciudad;

	//bi-directional many-to-one association to Provincia
    @ManyToOne
	private Provincia provincia;

	//bi-directional many-to-one association to Ubigeo
	@OneToMany(mappedBy="ciudad")
	private Set<Ubigeo> ubigeos;

    public Ciudad() {
    }

	public int getIdCiudad() {
		return this.idCiudad;
	}

	public void setIdCiudad(int idCiudad) {
		this.idCiudad = idCiudad;
	}

	public String getDescciudad() {
		return this.descciudad;
	}

	public void setDescciudad(String descciudad) {
		this.descciudad = descciudad;
	}

	public Provincia getProvincia() {
		return this.provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}
	
	public Set<Ubigeo> getUbigeos() {
		return this.ubigeos;
	}

	public void setUbigeos(Set<Ubigeo> ubigeos) {
		this.ubigeos = ubigeos;
	}
	
}