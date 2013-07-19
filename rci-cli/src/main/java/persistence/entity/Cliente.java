package persistence.entity;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the cliente database table.
 * 
 */
@Entity
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String apellido;

	private String direccion;

	private String email;

	private String loginpassword;

	private String loginuser;

	private String nombre;

	private String numeroDocumentoIdentidad;

	private String telefonoCelular;

	private String telefonoPrincipal;

	//bi-directional many-to-one association to Generopersona
    @ManyToOne
	@JoinColumn(name="genero_id")
	private Generopersona generopersona;

	//bi-directional many-to-one association to Empresacliente
    @ManyToOne(cascade=CascadeType.PERSIST)
	private Empresacliente empresacliente;

	//bi-directional many-to-one association to Tipodocumento
    @ManyToOne
	private Tipodocumento tipodocumento;

	//bi-directional many-to-one association to Ubigeo
    @ManyToOne
	private Ubigeo ubigeo;

	//bi-directional many-to-one association to Tipocliente
    @ManyToOne
	private Tipocliente tipocliente;

	//bi-directional many-to-one association to Pedido
	@OneToMany(mappedBy="cliente")
	private List<Pedido> pedidos;

    public Cliente() {
    }

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLoginpassword() {
		return this.loginpassword;
	}

	public void setLoginpassword(String loginpassword) {
		this.loginpassword = loginpassword;
	}

	public String getLoginuser() {
		return this.loginuser;
	}

	public void setLoginuser(String loginuser) {
		this.loginuser = loginuser;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNumeroDocumentoIdentidad() {
		return this.numeroDocumentoIdentidad;
	}

	public void setNumeroDocumentoIdentidad(String numeroDocumentoIdentidad) {
		this.numeroDocumentoIdentidad = numeroDocumentoIdentidad;
	}

	public String getTelefonoCelular() {
		return this.telefonoCelular;
	}

	public void setTelefonoCelular(String telefonoCelular) {
		this.telefonoCelular = telefonoCelular;
	}

	public String getTelefonoPrincipal() {
		return this.telefonoPrincipal;
	}

	public void setTelefonoPrincipal(String telefonoPrincipal) {
		this.telefonoPrincipal = telefonoPrincipal;
	}

	public Generopersona getGeneropersona() {
		return this.generopersona;
	}

	public void setGeneropersona(Generopersona generopersona) {
		this.generopersona = generopersona;
	}
	
	public Empresacliente getEmpresacliente() {
		return this.empresacliente;
	}

	public void setEmpresacliente(Empresacliente empresacliente) {
		this.empresacliente = empresacliente;
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
	
	public Tipocliente getTipocliente() {
		return this.tipocliente;
	}

	public void setTipocliente(Tipocliente tipocliente) {
		this.tipocliente = tipocliente;
	}
	
	public List<Pedido> getPedidos() {
		return this.pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	
}