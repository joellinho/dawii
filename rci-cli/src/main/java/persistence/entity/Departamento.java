package persistence.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the departamento database table.
 * 
 */
@Entity
public class Departamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idDepartamento;

	private String descDepartamento;

    public Departamento() {
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

}