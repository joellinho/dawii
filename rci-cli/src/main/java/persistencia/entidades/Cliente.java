package persistencia.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * The persistent class for the cliente database table.
 * 
 */
@Entity
public class Cliente  {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(columnDefinition="INT(11)")
	private int id;
	
	@Column(nullable=false, length=255)
	private String apellido;
	
	@Column(length=8,nullable=false,unique=true)
	private String dni;

	@Column(nullable=false, length=50)
	private String nombre;

	private Direccion direccion;


	@Column(nullable=false,length=50,unique=true)
	private String email;

	@Column(nullable=false, length=15)
	private String telefono;

	//bi-directional many-to-one association to Tipocliente
	@ManyToOne(fetch=FetchType.EAGER)
	private TipoCliente tipocliente;
	
	private byte[] foto;

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public String getApellido() {
		return this.apellido;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDni() {
		return this.dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public TipoCliente getTipocliente() {
		return this.tipocliente;
	}

	public void setTipocliente(TipoCliente tipocliente) {
		this.tipocliente = tipocliente;
	}

	public int getId() {
		return id;
	}


	
	

}