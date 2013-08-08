package web.converter;

import java.util.StringTokenizer;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import persistence.entity.UbigeoDist;
import persistence.entity.UbigeoDistPK;
import persistence.servicefactory.ServiceFactory;
import persistence.servicefactory.UbigeoDistService;

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
			updk.setUdiCod(st.nextToken());
			updk.setUpCod(st.nextToken());
			updk.setUdCod(st.nextToken());
			
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
		return udActual.getId().getUdiCod() + ";" + udActual.getId().getUpCod() + ";" + udActual.getId().getUdCod();			
	}
	
	
}
