package persistence.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the provincia database table.
 * 
 */
@Entity
public class Provincia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idProvincia;

	private String descprovincia;

	//bi-directional many-to-one association to Ciudad
	@OneToMany(mappedBy="provincia")
	private Set<Ciudad> ciudads;

	//bi-directional many-to-one association to Departament
    @ManyToOne
	private Departament departament;

    public Provincia() {
    }

	public int getIdProvincia() {
		return this.idProvincia;
	}

	public void setIdProvincia(int idProvincia) {
		this.idProvincia = idProvincia;
	}

	public String getDescprovincia() {
		return this.descprovincia;
	}

	public void setDescprovincia(String descprovincia) {
		this.descprovincia = descprovincia;
	}

	public Set<Ciudad> getCiudads() {
		return this.ciudads;
	}

	public void setCiudads(Set<Ciudad> ciudads) {
		this.ciudads = ciudads;
	}
	
	public Departament getDepartament() {
		return this.departament;
	}

	public void setDepartament(Departament departament) {
		this.departament = departament;
	}
	
}