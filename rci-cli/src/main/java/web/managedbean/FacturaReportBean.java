package web.managedbean;

import java.util.HashMap;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import report.common.AbstractReportBean;


@ManagedBean(name = "facturaReportBean")
@SessionScoped 
public class FacturaReportBean extends AbstractReportBean{

	 private final String COMPILE_FILE_NAME = "facturaRep";
	 private String fact_id; 
	 
    @Override
    protected String getCompileFileName() {
        return COMPILE_FILE_NAME;
    }
 
    @Override
    protected Map<String, Object> getReportParameters() {
        Map<String, Object> reportParameters = new HashMap<String, Object>();
 
        reportParameters.put("fact_id", fact_id);
 
        return reportParameters;
    }
    
 
    public String execute() {
        try {
            super.prepareReport();
        } catch (Exception e) {
            // make your own exception handling
            e.printStackTrace();
        }
 
        return null;
    }

	public String getFact_id() {
		return fact_id;
	}

	public void setFact_id(String fact_id) {
		this.fact_id = fact_id;
	}
}
