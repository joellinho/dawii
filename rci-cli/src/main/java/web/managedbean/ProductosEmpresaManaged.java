package web.managedbean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

import persistence.entity.Empresacomercial;
import persistence.servicefactory.EmpresacomercialService;
import persistence.servicefactory.ServiceFactory;;

@ManagedBean(name="productosEmpresaManaged")
@ViewScoped
public class ProductosEmpresaManaged {
	
	private EmpresacomercialService ecServ = ServiceFactory.obtenerServiceFactory().obtenerEmpresacomercialService();
	private List<Empresacomercial> listaEmpresa;
	
	public ProductosEmpresaManaged(){
		listaEmpresa = ecServ.listarConProductos();
	}

	public List<Empresacomercial> getListaEmpresa() {
		return listaEmpresa;
	}

	public void setListaEmpresa(List<Empresacomercial> listaEmpresa) {
		this.listaEmpresa = listaEmpresa;
	}
	
	
}
