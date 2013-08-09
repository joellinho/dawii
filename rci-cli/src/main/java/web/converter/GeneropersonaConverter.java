package web.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import persistence.entity.Generopersona;
import persistence.servicefactory.GeneroPersonaService;
import persistence.servicefactory.ServiceFactory;

@FacesConverter(value="generoPersonaConverter")
public class GeneropersonaConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		
		if(value==null|| value.equals("")){
            return null;
        }
		
		int id = -1;
		
		//Trycatch?
		id = Integer.parseInt(value);
		
		GeneroPersonaService gs = ServiceFactory.obtenerServiceFactory().obtenerGeneroClienteService();
		return gs.findById(id);
		
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		
		if(value==null|| !(value instanceof Generopersona)){
            return null;
        }
		
		Generopersona gpActual = (Generopersona) value;
		return String.valueOf(gpActual.getId());			
	}

}
