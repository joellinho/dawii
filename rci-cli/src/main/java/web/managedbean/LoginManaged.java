package web.managedbean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import persistence.entity.Cliente;
import persistencia.servicefactory.ClienteService;
import persistencia.servicefactory.ServiceFactory;

@ManagedBean(name="managedBean")
@SessionScoped
public class LoginManaged {
	private ClienteService cliServ = ServiceFactory.obtenerServiceFactory().obtenerClienteService();
	
	private String user;
	private String pass;
	private Cliente clienteLogeado;
	
		
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
			return null;
		}
		else{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Mensaje", "Usuario y/o Contraseña incorrectos."));  
			return null;			
		}
	}
	
	
}
