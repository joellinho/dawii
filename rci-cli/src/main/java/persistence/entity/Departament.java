package persistence.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the departament database table.
 * 
 */
@Entity
public class Departament implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idDepartamento;

	private String descDepartamento;

	//bi-directional many-to-one association to Provincia
	@OneToMany(mappedBy="departament")
	private Set<Provincia> provincias;

    public Departament() {
    }

	public int getIdDepartamento() {
		return this.idDepartamento;
	}

	public void setIdDepartamento(int idDepartamento) {
		this.idDepartamento = idDepartamento;
	}

	public String getDescDepartamento() {
		return this.descDepartamento;
	}

	public void setDescDepartamento(String descDepartamento) {
		this.descDepartamento = descDepartamento;
	}

	public Set<Provincia> getProvincias() {
		return this.provincias;
	}

	public void setProvincias(Set<Provincia> provincias) {
		this.provincias = provincias;
	}
	
}