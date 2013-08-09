package web.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import persistence.entity.Tipocomprobante;
import persistence.servicefactory.ServiceFactory;
import persistence.servicefactory.TipocomprobanteService;

@FacesConverter(value="tipocomprobanteConverter")
public class TipocomprobanteConverter implements Converter {
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		
		if(value==null|| value.equals("")){
            return null;
        }
		
		int id = -1;
		
		//Trycatch?
		try{
			id = Integer.parseInt(value);
		}
		catch (NumberFormatException pex){
			id = -1;
		}
		TipocomprobanteService tds = ServiceFactory.obtenerServiceFactory().obtenerTipocomprobanteService();
		return tds.findById(id);
		
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		
		if(value==null|| !(value instanceof Tipocomprobante)){
            return null;
        }
		
		Tipocomprobante gpActual = (Tipocomprobante) value;
		return String.valueOf(gpActual.getId());			
	}
	
}
