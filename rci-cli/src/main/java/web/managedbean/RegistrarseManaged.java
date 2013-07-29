package web.managedbean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import persistence.entity.Cliente;
import persistence.entity.Empresacliente;
import persistence.entity.Tipocliente;
import persistence.entity.Tipodocumento;
import persistence.servicefactory.ClienteService;
import persistence.servicefactory.EmpresaClienteService;
import persistence.servicefactory.ServiceFactory;
import persistence.servicefactory.TipoclienteService;
import persistence.servicefactory.TipodocumentoService;


@ManagedBean(name="registrarseManaged")
public class RegistrarseManaged {
	// Service
	private TipodocumentoService tipoDocServ = ServiceFactory.obtenerServiceFactory().obtenerTipoDocumentoService();
	private TipoclienteService tipoCliServ = ServiceFactory.obtenerServiceFactory().obtenerTipoclienteService();
	private ClienteService cliServ = ServiceFactory.obtenerServiceFactory().obtenerClienteService();
	private EmpresaClienteService empServ = ServiceFactory.obtenerServiceFactory().obtenerEmpresaClienteService();
	
	// Listado de Tipo Documento
	private List<Tipodocumento> listaTipoDoc;
	
	// Atributos del nuevo Usuario
	private String apellido;
	private String nombre;
	private String direccion;
	private String email;
	private String loginPassword;
	private String loginPassword2;
	//private String loginUser; 
	private String numeroDocumentoIdentidad; 
	private String telefonoCelular; 
	private String telefonoPrincipal; 
	private Tipodocumento tipoDocSeleccionado;
	
	// Atributos de la empresa
	private String razonSocial;
	private String rucEmpresa;
	
	// Constructor
	public TipodocumentoService getTipoDocServ() {
		return tipoDocServ;
	}
	
	// Insertar Usuario
	public String insertarUsuario(ActionEvent action){
		//TODO: Validaciones del usuario.
			
		
		// Creamos el cliente 		
		Cliente cli = new Cliente();
		cli.setApellido(this.apellido);
		cli.setNombre(this.nombre);
		cli.setDireccion(this.direccion);
		cli.setEmail(this.email);
		cli.setLoginpassword(this.loginPassword);
		//cli.setLoginuser(this.loginUser);
		cli.setNumeroDocumentoIdentidad(this.numeroDocumentoIdentidad);
		cli.setTelefonoCelular(this.telefonoCelular);
		cli.setTelefonoPrincipal(this.telefonoPrincipal);
		cli.setTipodocumento(this.tipoDocSeleccionado);
		
		// Buscamos la empresa, si no la encontramos creamos una nueva
		//TODO: Deberiamos comprobar si la razon social es la misma?
		
		Empresacliente ec = null;
		
		// Comrpobamos que se aya escrito datos, si no simplemente ignoramos
		if(!(rucEmpresa==null) && !(rucEmpresa.equals(""))){
			ec = empServ.buscarEmpresaClientePorRuc(rucEmpresa);
			if(ec==null){
				ec = new Empresacliente();
				ec.setRazonsocial(razonSocial);
				ec.setRuc(rucEmpresa);			
			}
		}
		
		// Asignamos la empresa
		cli.setEmpresacliente(ec);
		
		if (loginPassword.equals(loginPassword2)) {
			cliServ.insertar(cli);
			return "main";
		}
	    else{
	    	FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Mensaje", "Las Contraseñas no son Iguales."));
	    	return null;
		}
		
		
	}
	
	public String test(){
		
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
		this.listaTipoDoc = tipoDocServ.listarDocumento();
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

	/*public String getLoginUser() {
		return loginUser;
	}

	public void setLoginUser(String loginUser) {
		this.loginUser = loginUser;
	} */

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
	
	public String getLoginPassword2() {
		return loginPassword2;
	}

	public void setLoginPassword2(String loginPassword2) {
		this.loginPassword2 = loginPassword2;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getrucEmpresa() {
		return rucEmpresa;
	}

	public void setrucEmpresa(String ruc) {
		this.rucEmpresa = ruc;
	}
}
