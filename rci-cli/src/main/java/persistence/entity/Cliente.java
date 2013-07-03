package persistence.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


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

    @Lob()
	private byte[] foto;

	private String nombre;

	private String nrodocid;

	private String telefono;

	//bi-directional many-to-one association to Ubigeo
    @ManyToOne
	private Ubigeo ubigeo;

	//bi-directional many-to-one association to Tipodocumento
    @ManyToOne
	private Tipodocumento tipodocumento;

	//bi-directional many-to-one association to Tipocliente
    @ManyToOne
	private Tipocliente tipocliente;

	//bi-directional many-to-one association to Documentocomercial
	@OneToMany(mappedBy="cliente")
	private Set<Documentocomercial> documentocomercials;

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

	public byte[] getFoto() {
		return this.foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNrodocid() {
		return this.nrodocid;
	}

	public void setNrodocid(String nrodocid) {
		this.nrodocid = nrodocid;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Ubigeo getUbigeo() {
		return this.ubigeo;
	}

	public void setUbigeo(Ubigeo ubigeo) {
		this.ubigeo = ubigeo;
	}
	
	public Tipodocumento getTipodocumento() {
		return this.tipodocumento;
	}

	public void setTipodocumento(Tipodocumento tipodocumento) {
		this.tipodocumento = tipodocumento;
	}
	
	public Tipocliente getTipocliente() {
		return this.tipocliente;
	}

	public void setTipocliente(Tipocliente tipocliente) {
		this.tipocliente = tipocliente;
	}
	
	public Set<Documentocomercial> getDocumentocomercials() {
		return this.documentocomercials;
	}

	public void setDocumentocomercials(Set<Documentocomercial> documentocomercials) {
		this.documentocomercials = documentocomercials;
	}
	
}