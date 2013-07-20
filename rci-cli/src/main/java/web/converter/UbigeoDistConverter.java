package web.converter;

import java.util.StringTokenizer;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import persistence.entity.UbigeoDist;
import persistence.entity.UbigeoDistPK;
import persistencia.servicefactory.ServiceFactory;
import persistencia.servicefactory.UbigeoDistService;

@FacesConverter(value="ubigeoDistConverter")
public class UbigeoDistConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		
		if(value==null|| value.equals("")){
            return null;
        }		

		UbigeoDistPK updk = new UbigeoDistPK();
		StringTokenizer st = new StringTokenizer(value, ";");
		UbigeoDist udis = null;
		
		if(st.countTokens()==3)
		{			
			updk.setUdicod(st.nextToken());
			updk.setUpcod(st.nextToken());
			updk.setUdcod(st.nextToken());
			
			UbigeoDistService uds = ServiceFactory.obtenerServiceFactory().obtenerUbigeoDistService();
			udis = uds.obtenerPorId(updk);
		}
		
		return udis;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		
		if(value==null|| !(value instanceof UbigeoDist)){
            return null;
        }
		
		UbigeoDist udActual = (UbigeoDist) value;
		return udActual.getId().getUdicod() + ";" + udActual.getId().getUpcod() + ";" + udActual.getId().getUdcod();			
	}
	
	
}
