package web.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import persistence.entity.Tipodocumento;
import persistence.servicefactory.ServiceFactory;
import persistence.servicefactory.TipodocumentoService;

@FacesConverter(value="tipoDocumentoConverter")
public class TipoDocumentoConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		
		if(value==null|| value.equals("")){
            return null;
        }
		
		int id = -1;
		
		//Trycatch?
		id = Integer.parseInt(value);
		
		TipodocumentoService tds = ServiceFactory.obtenerServiceFactory().obtenerTipoDocumentoService();
		return tds.findById(id);
		
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		
		if(value==null|| !(value instanceof Tipodocumento)){
            return null;
        }
		
		Tipodocumento gpActual = (Tipodocumento) value;
		return String.valueOf(gpActual.getId());			
	}

}
