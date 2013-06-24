package persistence.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the productoxtienda database table.
 * 
 */
@Entity
public class Productoxtienda implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idproductoxtienda;

	private int productoxempresa_Empresa_idEmpresa;

	//bi-directional many-to-one association to Detallepedido
	@OneToMany(mappedBy="productoxtienda")
	private Set<Detallepedido> detallepedidos;

	//bi-directional many-to-one association to Productoxempresa
    @ManyToOne
	private Productoxempresa productoxempresa;

	//bi-directional many-to-one association to Tienda
    @ManyToOne
	private Tienda tienda;

    public Productoxtienda() {
    }

	public int getIdproductoxtienda() {
		return this.idproductoxtienda;
	}

	public void setIdproductoxtienda(int idproductoxtienda) {
		this.idproductoxtienda = idproductoxtienda;
	}

	public int getProductoxempresa_Empresa_idEmpresa() {
		return this.productoxempresa_Empresa_idEmpresa;
	}

	public void setProductoxempresa_Empresa_idEmpresa(int productoxempresa_Empresa_idEmpresa) {
		this.productoxempresa_Empresa_idEmpresa = productoxempresa_Empresa_idEmpresa;
	}

	public Set<Detallepedido> getDetallepedidos() {
		return this.detallepedidos;
	}

	public void setDetallepedidos(Set<Detallepedido> detallepedidos) {
		this.detallepedidos = detallepedidos;
	}
	
	public Productoxempresa getProductoxempresa() {
		return this.productoxempresa;
	}

	public void setProductoxempresa(Productoxempresa productoxempresa) {
		this.productoxempresa = productoxempresa;
	}
	
	public Tienda getTienda() {
		return this.tienda;
	}

	public void setTienda(Tienda tienda) {
		this.tienda = tienda;
	}
	
}