package persistence.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the estadoregistropedido database table.
 * 
 */
@Entity
public class Estadoregistropedido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String descripcion;

	//bi-directional many-to-one association to Documentocomercial
	@OneToMany(mappedBy="estadoregistropedido")
	private Set<Documentocomercial> documentocomercials;

    public Estadoregistropedido() {
    }

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Set<Documentocomercial> getDocumentocomercials() {
		return this.documentocomercials;
	}

	public void setDocumentocomercials(Set<Documentocomercial> documentocomercials) {
		this.documentocomercials = documentocomercials;
	}
	
}