package persistence.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ubigeopais database table.
 * 
 */
@Entity
@Table(name="ubigeopais")
public class Ubigeopai implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cod_pais")
	private String codPais;

	@Column(name="nom_pais")
	private String nomPais;

    public Ubigeopai() {
    }

	public String getCodPais() {
		return this.codPais;
	}

	public void setCodPais(String codPais) {
		this.codPais = codPais;
	}

	public String getNomPais() {
		return this.nomPais;
	}

	public void setNomPais(String nomPais) {
		this.nomPais = nomPais;
	}

}