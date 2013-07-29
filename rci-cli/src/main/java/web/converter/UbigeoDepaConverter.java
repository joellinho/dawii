package web.converter;


import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import persistence.entity.UbigeoDepa;
import persistence.servicefactory.ServiceFactory;
import persistence.servicefactory.UbigeoDepaService;

@FacesConverter(value="ubigeoDepaConverter")
public class UbigeoDepaConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		
		if(value==null|| value.equals("")){
            return null;
        }		
		
			
		UbigeoDepaService uds = ServiceFactory.obtenerServiceFactory().obtenerUbigeoDepaService();

				
		return uds.obtenerPorId(value);
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		
		if(value==null|| !(value instanceof UbigeoDepa)){
            return null;
        }
		
		UbigeoDepa udActual = (UbigeoDepa) value;
		return String.valueOf(udActual.getUdcod());			
	}
	
}
