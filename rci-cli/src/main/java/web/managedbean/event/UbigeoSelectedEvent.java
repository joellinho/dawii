package web.managedbean.event;

import java.util.EventObject;

import persistence.entity.Ubigeo;

public class UbigeoSelectedEvent extends EventObject {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;


    public UbigeoSelectedEvent(Object source) {
        super(source);
    }
    
    public Ubigeo getUbigeoSeleccionado() {
		return ubigeoSeleccionado;
	}

	public void setUbigeoSeleccionado(Ubigeo ubigeoSeleccionado) {
		this.ubigeoSeleccionado = ubigeoSeleccionado;
	}

	private Ubigeo ubigeoSeleccionado;
}
