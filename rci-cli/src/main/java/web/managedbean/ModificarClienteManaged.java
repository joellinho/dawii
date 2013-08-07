package web.managedbean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import persistence.entity.Cliente;
import persistence.entity.Empresacliente;
import persistence.entity.Tipodocumento;
import persistence.servicefactory.ClienteService;
import persistence.servicefactory.EmpresaClienteService;
import persistence.servicefactory.ServiceFactory;
import persistence.servicefactory.TipoclienteService;
import persistence.servicefactory.TipodocumentoService;


@ManagedBean(name="modificarClienteManaged")
@ViewScoped
public class ModificarClienteManaged {
	// Service
	private TipodocumentoService tipoDocServ = ServiceFactory.obtenerServiceFactory().obtenerTipoDocumentoService();
	private TipoclienteService tipoCliServ = ServiceFactory.obtenerServiceFactory().obtenerTipoclienteService();
	private ClienteService cliServ = ServiceFactory.obtenerServiceFactory().obtenerClienteService();
	private EmpresaClienteService empServ = ServiceFactory.obtenerServiceFactory().obtenerEmpresaClienteService();
	
	// Listado de Tipo Documento
	private List<Tipodocumento> listaTipoDoc;
	
	// Copia del Usuario a modificar
	private Cliente clienteLogeadoCopy;
		
	// Atributos de la empresa
	private String razonSocial;
	private String rucEmpresa;
	
	// Managed Bean Login
	@ManagedProperty(value="#{loginManaged}")
	private LoginManaged loginManaged;

	// Managed Bean Ubigeo
	@ManagedProperty(value="#{ubigeoManaged}")
	private UbigeoManaged ubigeoManaged;
		
	public ModificarClienteManaged(){
		// Cargamos el combo
		this.listaTipoDoc = tipoDocServ.listarDocumento();
	}	
	
	@PostConstruct
	public void init(){
		// Trasladamos los datos
		this.clienteLogeadoCopy = this.loginManaged.getClienteLogeado();
		this.razonSocial = this.clienteLogeadoCopy.getEmpresacliente().getRazonsocial();
		this.rucEmpresa = this.clienteLogeadoCopy.getEmpresacliente().getRuc();		
		this.ubigeoManaged.forzarUbigeo(this.clienteLogeadoCopy.getUbigeo());
	}
	
	public String modificar(){
		// Primero debemos verificar si se cambio la empresa.
		boolean rsCambiado =  !this.razonSocial.equals(this.clienteLogeadoCopy.getEmpresacliente().getRazonsocial());
		boolean rucCambiado = !this.rucEmpresa.equals(this.clienteLogeadoCopy.getEmpresacliente().getRuc());
		Empresacliente ec = null;
		
		// Si se cambio el ruc, debemos buscar en la bd una empresacliente con ese RUC
		// si no se encuentra debemos inscribir uno.
		if(rucCambiado){
			if(!(rucEmpresa==null) && !(rucEmpresa.equals(""))){
				ec = empServ.buscarEmpresaClientePorRuc(rucEmpresa);
				if(ec==null){
					ec = new Empresacliente();
					ec.setRazonsocial(razonSocial);
					ec.setRuc(rucEmpresa);			
				}
			}
		}
		// Si solo se cambio la razon social, actualizamos (?)
		else if(rsCambiado){
			ec = this.clienteLogeadoCopy.getEmpresacliente();
			ec.setRazonsocial(this.razonSocial);
		}
		// Si no se cambio nada--
		else{
			ec = this.clienteLogeadoCopy.getEmpresacliente();
		}
		
		// Ahora que ya tenemos la razon social, debemos actualizar la data
		this.clienteLogeadoCopy.setEmpresacliente(ec);
		this.clienteLogeadoCopy.setUbigeo(this.ubigeoManaged.getUbiSelect());
		cliServ.actualizar(this.clienteLogeadoCopy);
		this.loginManaged.setClienteLogeado(this.clienteLogeadoCopy);		
		return "modificarExito";
	}
	
	// Getters and Setters
	public List<Tipodocumento> getListaTipoDoc() {
		return listaTipoDoc;
	}

	public void setListaTipoDoc(List<Tipodocumento> listaTipoDoc) {
		this.listaTipoDoc = listaTipoDoc;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getRucEmpresa() {
		return rucEmpresa;
	}

	public void setRucEmpresa(String rucEmpresa) {
		this.rucEmpresa = rucEmpresa;
	}

	public LoginManaged getLoginManaged() {
		return loginManaged;
	}

	public void setLoginManaged(LoginManaged loginManaged) {
		this.loginManaged = loginManaged;
	}

	public Cliente getClienteLogeadoCopy() {
		return clienteLogeadoCopy;
	}

	public void setClienteLogeadoCopy(Cliente clienteLogeadoCopy) {
		this.clienteLogeadoCopy = clienteLogeadoCopy;
	}

	public UbigeoManaged getUbigeoManaged() {
		return ubigeoManaged;
	}

	public void setUbigeoManaged(UbigeoManaged ubigeoManaged) {
		this.ubigeoManaged = ubigeoManaged;
	}
	
	
}
