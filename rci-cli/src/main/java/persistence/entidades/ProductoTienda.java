package persistence.entidades;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class ProductoTienda{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(columnDefinition="INT(11)")
	private int id;
	
	
	@Column(length=50,nullable=false,unique=true)
	private String descripcion;

	private byte[] foto;


	@Column(length = 32)
	private String masFotos;

	private String observaciones;

	@Column(precision=19, scale=2)
	private BigDecimal precio;

	//bi-directional many-to-one association to Categoriaproducto
	@ManyToOne(fetch=FetchType.LAZY)
	private CategoriaProducto categoriaproducto;

	//bi-directional many-to-one association to Tienda
	@ManyToOne(fetch=FetchType.LAZY)
	private Tienda tienda;	

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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

	public BigDecimal getPrecio() {
		return this.precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public CategoriaProducto getCategoriaproducto() {
		return this.categoriaproducto;
	}

	public void setCategoriaproducto(CategoriaProducto categoriaproducto) {
		this.categoriaproducto = categoriaproducto;
	}

	public Tienda getTienda() {
		return this.tienda;
	}

	public void setTienda(Tienda tienda) {
		this.tienda = tienda;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}