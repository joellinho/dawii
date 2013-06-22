package persistence.entidades;

import javax.persistence.*;


/**
 * The persistent class for the tipocliente database table.
 * 
 */
@Entity
public class TipoCliente  {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(columnDefinition="INT(11)")
	private int id;
		

	private String descripcion;
	
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}