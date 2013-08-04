package persistence.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


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

	private String masfotos;

	private String observaciones;

	private BigDecimal preciocosto;

	private BigDecimal precioventa;

	//bi-directional many-to-one association to Empresacomercial
    @ManyToOne
	@JoinColumn(name="empresa_id")
	private Empresacomercial empresacomercial;

	//bi-directional many-to-one association to Categoriaproducto
    @ManyToOne
	@JoinColumn(name="categoria_id")
	private Categoriaproducto categoriaproducto;

	//bi-directional many-to-one association to Productotienda
	@OneToMany(mappedBy="productoempresa")
	private List<Productotienda> productotiendas;

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

	public String getMasfotos() {
		return this.masfotos;
	}

	public void setMasfotos(String masfotos) {
		this.masfotos = masfotos;
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

	public Empresacomercial getEmpresacomercial() {
		return this.empresacomercial;
	}

	public void setEmpresacomercial(Empresacomercial empresacomercial) {
		this.empresacomercial = empresacomercial;
	}
	
	public Categoriaproducto getCategoriaproducto() {
		return this.categoriaproducto;
	}

	public void setCategoriaproducto(Categoriaproducto categoriaproducto) {
		this.categoriaproducto = categoriaproducto;
	}
	
	public List<Productotienda> getProductotiendas() {
		return this.productotiendas;
	}

	public void setProductotiendas(List<Productotienda> productotiendas) {
		this.productotiendas = productotiendas;
	}
	
}