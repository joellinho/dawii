package web.managedbean;

import java.util.HashMap;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import report.common.AbstractReportBean;


@ManagedBean(name = "pedidosReport")
@SessionScoped 
public class PedidosReport extends AbstractReportBean{

	 private final String COMPILE_FILE_NAME = "UltimosPedidos";
	 
	 @ManagedProperty(value="#{loginManaged}")
		private LoginManaged loginManaged;
		
	 
    @Override
    protected String getCompileFileName() {
        return COMPILE_FILE_NAME;
    }
 
    @Override
    protected Map<String, Object> getReportParameters() {
        Map<String, Object> reportParameters = new HashMap<String, Object>();
 
        reportParameters.put("cli_id", loginManaged.getClienteLogeado().getId());
 
        return reportParameters;
    }
    
 
    public String execute() {
        try {
        	if(loginManaged.isLoggedIn()){
        		this.setExportOption(ExportOption.PDF);
            	super.prepareReport();
        	}
        } catch (Exception e) {
            // make your own exception handling
            e.printStackTrace();
        }
 
        return null;
    }

	public LoginManaged getLoginManaged() {
		return loginManaged;
	}

	public void setLoginManaged(LoginManaged loginManaged) {
		this.loginManaged = loginManaged;
	}
}

