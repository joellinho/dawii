package web.managedbean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import persistence.entity.Cliente;
import persistence.servicefactory.ClienteService;
import persistence.servicefactory.ServiceFactory;
import web.managedbean.event.UbigeoSelectedEvent;
import web.managedbean.event.UbigeoSelectedListener;

@ManagedBean(name="loginManaged")
@SessionScoped
public class LoginManaged implements UbigeoSelectedListener {
	private ClienteService cliServ = ServiceFactory.obtenerServiceFactory().obtenerClienteService();
	
	private String user;
	private String pass;
	private Cliente clienteLogeado;
	
	// Managed Bean Ubigeo
	@ManagedProperty(value="#{ubigeoManaged}")
	private UbigeoManaged ubigeoManaged;
		
	public String getUser() {
		return user;
	}
	
	public void setUser(String user) {
		this.user = user;
	}
	
	public String getPass() {
		return pass;
	}
	
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	public Cliente getClienteLogeado() {
		return clienteLogeado;
	}
	
	public void setClienteLogeado(Cliente clienteLogeado) {
		this.clienteLogeado = clienteLogeado;
	}
	
	public String autenticar(){
		this.clienteLogeado = cliServ.buscarPorUserPass(user, pass);
		if(clienteLogeado!=null){	
			return "/main";
		}
		else{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Mensaje", "Usuario y/o Contraseña incorrectos."));  
			return null;			
		}
	}
	
	public void modificar(){
		if(this.clienteLogeado!=null){
			this.cliServ.actualizar(clienteLogeado);
		}
	}
	
	public boolean isLoggedIn(){
		return this.clienteLogeado!=null;
	}

	public UbigeoManaged getUbigeoManaged() {
		return ubigeoManaged;
	}

	public void setUbigeoManaged(UbigeoManaged ubigeoManaged) {

		if(this.ubigeoManaged!=null){
			this.ubigeoManaged.removeUbigeoSelectedEventListener(this);
		}
		
		this.ubigeoManaged = ubigeoManaged;
		this.ubigeoManaged.addUbigeoSelectedEventListener(this);
	}

	@Override
	public void handleUbigeoSelectedEvent(UbigeoSelectedEvent e) {
		if(this.clienteLogeado!=null){
			this.clienteLogeado.setUbigeo(e.getUbigeoSeleccionado());
		}
		
	}
}
