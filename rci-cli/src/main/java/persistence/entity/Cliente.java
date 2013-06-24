package persistence.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the clientes database table.
 * 
 */
@Entity
@Table(name="clientes")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idclientes;

	private String cellcliente;

	private String direccion;

	private String dnicliente;

	@Column(name="`nombre cliente`")
	private String nombre_cliente;

	private String telfcliente;

	//bi-directional many-to-one association to Tipocliente
    @ManyToOne
	private Tipocliente tipocliente;

	//bi-directional many-to-one association to Tipodocumento
    @ManyToOne
	private Tipodocumento tipodocumento;

	//bi-directional many-to-one association to Ubigeo
    @ManyToOne
	private Ubigeo ubigeo;

	//bi-directional many-to-one association to Registropedido
	@OneToMany(mappedBy="cliente")
	private Set<Registropedido> registropedidos;

    public Cliente() {
    }

	public int getIdclientes() {
		return this.idclientes;
	}

	public void setIdclientes(int idclientes) {
		this.idclientes = idclientes;
	}

	public String getCellcliente() {
		return this.cellcliente;
	}

	public void setCellcliente(String cellcliente) {
		this.cellcliente = cellcliente;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDnicliente() {
		return this.dnicliente;
	}

	public void setDnicliente(String dnicliente) {
		this.dnicliente = dnicliente;
	}

	public String getNombre_cliente() {
		return this.nombre_cliente;
	}

	public void setNombre_cliente(String nombre_cliente) {
		this.nombre_cliente = nombre_cliente;
	}

	public String getTelfcliente() {
		return this.telfcliente;
	}

	public void setTelfcliente(String telfcliente) {
		this.telfcliente = telfcliente;
	}

	public Tipocliente getTipocliente() {
		return this.tipocliente;
	}

	public void setTipocliente(Tipocliente tipocliente) {
		this.tipocliente = tipocliente;
	}
	
	public Tipodocumento getTipodocumento() {
		return this.tipodocumento;
	}

	public void setTipodocumento(Tipodocumento tipodocumento) {
		this.tipodocumento = tipodocumento;
	}
	
	public Ubigeo getUbigeo() {
		return this.ubigeo;
	}

	public void setUbigeo(Ubigeo ubigeo) {
		this.ubigeo = ubigeo;
	}
	
	public Set<Registropedido> getRegistropedidos() {
		return this.registropedidos;
	}

	public void setRegistropedidos(Set<Registropedido> registropedidos) {
		this.registropedidos = registropedidos;
	}
	
}