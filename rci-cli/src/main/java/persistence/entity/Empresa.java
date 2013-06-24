package persistence.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the empresa database table.
 * 
 */
@Entity
public class Empresa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idEmpresa;

	private String descempresa;

	private String rucempresa;

	//bi-directional many-to-one association to Imagen
    @ManyToOne
	private Imagen imagen;

	//bi-directional many-to-one association to Productoxempresa
	@OneToMany(mappedBy="empresa")
	private Set<Productoxempresa> productoxempresas;

	//bi-directional many-to-one association to Tienda
	@OneToMany(mappedBy="empresa")
	private Set<Tienda> tiendas;

    public Empresa() {
    }

	public int getIdEmpresa() {
		return this.idEmpresa;
	}

	public void setIdEmpresa(int idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public String getDescempresa() {
		return this.descempresa;
	}

	public void setDescempresa(String descempresa) {
		this.descempresa = descempresa;
	}

	public String getRucempresa() {
		return this.rucempresa;
	}

	public void setRucempresa(String rucempresa) {
		this.rucempresa = rucempresa;
	}

	public Imagen getImagen() {
		return this.imagen;
	}

	public void setImagen(Imagen imagen) {
		this.imagen = imagen;
	}
	
	public Set<Productoxempresa> getProductoxempresas() {
		return this.productoxempresas;
	}

	public void setProductoxempresas(Set<Productoxempresa> productoxempresas) {
		this.productoxempresas = productoxempresas;
	}
	
	public Set<Tienda> getTiendas() {
		return this.tiendas;
	}

	public void setTiendas(Set<Tienda> tiendas) {
		this.tiendas = tiendas;
	}
	
}