package web.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import persistence.entity.Tienda;
import persistence.servicefactory.ServiceFactory;
import persistence.servicefactory.TiendaService;

@FacesConverter(value="tiendaConverter")
public class TiendaConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		
		if(value==null || value.equals("")){
			return null;
		}
		int id = -1;
		
		id = Integer.parseInt(value);
		
		TiendaService ts = ServiceFactory.obtenerServiceFactory().obtenerTiendaService();
		
		return ts.obtenerTiendaPorId(id);
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		if(value==null || !(value instanceof Tienda)){
			return null;
		}
		
		Tienda tiendaActual = (Tienda) value;
		// 
		return String.valueOf(tiendaActual.getId());
	}

	
	
}
