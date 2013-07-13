package web.managedbean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.event.ActionEvent;

import persistence.entity.Cliente;
import persistence.entity.Tipocliente;
import persistence.entity.Tipodocumento;
import persistencia.servicefactory.ClienteService;
import persistencia.servicefactory.ServiceFactory;
import persistencia.servicefactory.TipoclienteService;
import persistencia.servicefactory.TipodocumentoService;


@ManagedBean(name="registrarseManaged")
public class RegistrarseManaged {
	// Service
	private TipodocumentoService tipoDocServ = ServiceFactory.obtenerServiceFactory().obtenerTipoDocumentoService();
	private TipoclienteService tipoCliServ = ServiceFactory.obtenerServiceFactory().obtenerTipoclienteService();
	private ClienteService cliServ = ServiceFactory.obtenerServiceFactory().obtenerClienteService();
	
	// Listado de Tipo Documento
	private List<Tipodocumento> listaTipoDoc;
	
	// Atributos del nuevo Usuario
	private String apellido;
	private String nombre;
	private String direccion;
	private String email;
	private String loginPassword; //*
	private String loginUser; //*
	private String numeroDocumentoIdentidad; //*
	private String telefonoCelular; //*
	private String telefonoPrincipal; //*
	private Tipodocumento tipoDocSeleccionado;
	
	// Constructor
	public TipodocumentoService getTipoDocServ() {
		return tipoDocServ;
	}
	
	// Insertar Usuario
	public String insertarUsuario(ActionEvent action){
		// Obtengo el tipoCLiente
		// ALerta posible excepcion
		Tipocliente tipoCli =  tipoCliServ.listarTipoCliente().get(0);
		
		// Cliente		
		Cliente cli = new Cliente();
		cli.setApellido(this.apellido);
		cli.setNombre(this.nombre);
		cli.setDireccion(this.direccion);
		cli.setEmail(this.email);
		cli.setLoginpassword(this.loginPassword);
		cli.setLoginuser(this.loginUser);
		cli.setNumeroDocumentoIdentidad(this.numeroDocumentoIdentidad);
		cli.setTelefonoCelular(this.telefonoCelular);
		cli.setTelefonoPrincipal(this.telefonoPrincipal);
		cli.setTipodocumento(this.tipoDocSeleccionado);
		cli.setTipocliente(tipoCli);
		
		cliServ.insertar(cli);
		return null;
	}
	
	//=========Get/Set=========
	public void setTipoDocServ(TipodocumentoService tipoDocServ) {
		this.tipoDocServ = tipoDocServ;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public RegistrarseManaged(){
		this.listaTipoDoc = tipoDocServ.listar();
	}	

	public List<Tipodocumento> getListaTipoDoc() {
		return listaTipoDoc;
	}

	public void setListaTipoDoc(List<Tipodocumento> listaTipoDoc) {
		this.listaTipoDoc = listaTipoDoc;
	}

	public Tipodocumento getTipoDocSeleccionado() {
		return tipoDocSeleccionado;
	}

	public void setTipoDocSeleccionado(Tipodocumento tipoDocSeleccionado) {
		this.tipoDocSeleccionado = tipoDocSeleccionado;
	}
	
	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	public String getLoginUser() {
		return loginUser;
	}

	public void setLoginUser(String loginUser) {
		this.loginUser = loginUser;
	}

	public String getNumeroDocumentoIdentidad() {
		return numeroDocumentoIdentidad;
	}

	public void setNumeroDocumentoIdentidad(String numeroDocumentoIdentidad) {
		this.numeroDocumentoIdentidad = numeroDocumentoIdentidad;
	}

	public String getTelefonoCelular() {
		return telefonoCelular;
	}

	public void setTelefonoCelular(String telefonoCelular) {
		this.telefonoCelular = telefonoCelular;
	}

	public String getTelefonoPrincipal() {
		return telefonoPrincipal;
	}

	public void setTelefonoPrincipal(String telefonoPrincipal) {
		this.telefonoPrincipal = telefonoPrincipal;
	}
	
}
