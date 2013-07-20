package web.converter;

import java.util.StringTokenizer;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import persistence.entity.UbigeoProv;
import persistence.entity.UbigeoProvPK;
import persistencia.servicefactory.ServiceFactory;
import persistencia.servicefactory.UbigeoProvService;

@FacesConverter(value="ubigeoProvConverter")
public class UbigeoProvConverter implements Converter {
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		
		if(value==null|| value.equals("")){
            return null;
        }		

		UbigeoProvPK uppk = new UbigeoProvPK();
		StringTokenizer st = new StringTokenizer(value, ";");
		UbigeoProv uprov = null;
		
		if(st.countTokens()==2)
		{			
			uppk.setUdcod(st.nextToken());
			uppk.setUpcod(st.nextToken());
			UbigeoProvService ups = ServiceFactory.obtenerServiceFactory().obtenerUbigeoProvService();
			uprov = ups.obtenerPorId(uppk);
		}
		
		return uprov;
		
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		
		if(value==null|| !(value instanceof UbigeoProv)){
            return null;
        }
		
		UbigeoProv upActual = (UbigeoProv) value;
		return String.valueOf(upActual.getId().getUdcod() + ";" + upActual.getId().getUpcod() );			
	}

}
