package persistence.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;


/**
 * The persistent class for the productoxempresa database table.
 * 
 */
@Entity
public class Productoxempresa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idproductoxempresa;

	private String descproducto;

	private String estado;

	private BigDecimal preciocosto;

	private BigDecimal precioventa;

	//bi-directional many-to-one association to Categoriaxproducto
    @ManyToOne
	private Categoriaxproducto categoriaxproducto;

	//bi-directional many-to-one association to Empresa
    @ManyToOne
	private Empresa empresa;

	//bi-directional many-to-one association to Imagen
    @ManyToOne
	private Imagen imagen;

	//bi-directional many-to-one association to Productoxtienda
	@OneToMany(mappedBy="productoxempresa")
	private Set<Productoxtienda> productoxtiendas;

    public Productoxempresa() {
    }

	public int getIdproductoxempresa() {
		return this.idproductoxempresa;
	}

	public void setIdproductoxempresa(int idproductoxempresa) {
		this.idproductoxempresa = idproductoxempresa;
	}

	public String getDescproducto() {
		return this.descproducto;
	}

	public void setDescproducto(String descproducto) {
		this.descproducto = descproducto;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public BigDecimal getPreciocosto() {
		return this.preciocosto;
	}

	public void setPreciocosto(BigDecimal preciocosto) {
		this.preciocosto = preciocosto;
	}

	public BigDecimal getPrecioventa() {
		return this.precioventa;
	}

	public void setPrecioventa(BigDecimal precioventa) {
		this.precioventa = precioventa;
	}

	public Categoriaxproducto getCategoriaxproducto() {
		return this.categoriaxproducto;
	}

	public void setCategoriaxproducto(Categoriaxproducto categoriaxproducto) {
		this.categoriaxproducto = categoriaxproducto;
	}
	
	public Empresa getEmpresa() {
		return this.empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
	public Imagen getImagen() {
		return this.imagen;
	}

	public void setImagen(Imagen imagen) {
		this.imagen = imagen;
	}
	
	public Set<Productoxtienda> getProductoxtiendas() {
		return this.productoxtiendas;
	}

	public void setProductoxtiendas(Set<Productoxtienda> productoxtiendas) {
		this.productoxtiendas = productoxtiendas;
	}
	
}