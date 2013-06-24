package persistence.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the tienda database table.
 * 
 */
@Entity
public class Tienda implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idtienda;

	private String desctienda;

	private String telefonotienda;

	//bi-directional many-to-one association to Productoxtienda
	@OneToMany(mappedBy="tienda")
	private Set<Productoxtienda> productoxtiendas;

	//bi-directional many-to-one association to Empresa
    @ManyToOne
	private Empresa empresa;

    public Tienda() {
    }

	public int getIdtienda() {
		return this.idtienda;
	}

	public void setIdtienda(int idtienda) {
		this.idtienda = idtienda;
	}

	public String getDesctienda() {
		return this.desctienda;
	}

	public void setDesctienda(String desctienda) {
		this.desctienda = desctienda;
	}

	public String getTelefonotienda() {
		return this.telefonotienda;
	}

	public void setTelefonotienda(String telefonotienda) {
		this.telefonotienda = telefonotienda;
	}

	public Set<Productoxtienda> getProductoxtiendas() {
		return this.productoxtiendas;
	}

	public void setProductoxtiendas(Set<Productoxtienda> productoxtiendas) {
		this.productoxtiendas = productoxtiendas;
	}
	
	public Empresa getEmpresa() {
		return this.empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
}