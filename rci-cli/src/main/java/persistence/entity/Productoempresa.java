package persistence.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;


/**
 * The persistent class for the productoempresa database table.
 * 
 */
@Entity
public class Productoempresa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String descripcion;

    @Lob()
	private byte[] foto;

	private String masFotos;

	private String observaciones;

	private BigDecimal preciocosto;

	private BigDecimal precioventa;

	//bi-directional many-to-one association to Categoriaproducto
    @ManyToOne
	private Categoriaproducto categoriaproducto;

	//bi-directional many-to-one association to Empresa
    @ManyToOne
	private Empresa empresa;

	//bi-directional many-to-one association to Productotienda
	@OneToMany(mappedBy="productoempresa")
	private Set<Productotienda> productotiendas;

    public Productoempresa() {
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

	public byte[] getFoto() {
		return this.foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public String getMasFotos() {
		return this.masFotos;
	}

	public void setMasFotos(String masFotos) {
		this.masFotos = masFotos;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
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

	public Categoriaproducto getCategoriaproducto() {
		return this.categoriaproducto;
	}

	public void setCategoriaproducto(Categoriaproducto categoriaproducto) {
		this.categoriaproducto = categoriaproducto;
	}
	
	public Empresa getEmpresa() {
		return this.empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
	public Set<Productotienda> getProductotiendas() {
		return this.productotiendas;
	}

	public void setProductotiendas(Set<Productotienda> productotiendas) {
		this.productotiendas = productotiendas;
	}
	
}