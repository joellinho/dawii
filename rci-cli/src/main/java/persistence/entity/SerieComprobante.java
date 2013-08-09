package persistence.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Alvaro
 *
 */
@Entity
public class SerieComprobante {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Temporal( TemporalType.TIMESTAMP)
	private Date fechaReg;
	
	private int serieDoc;
	
	private int numeroDoc;
	
	@ManyToOne
	private Tipocomprobante tipocomprobante;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getFechaReg() {
		return fechaReg;
	}
	public void setFechaReg(Date fechaReg) {
		this.fechaReg = fechaReg;
	}
	public int getSerieDoc() {
		return serieDoc;
	}
	public void setSerieDoc(int serieDoc) {
		this.serieDoc = serieDoc;
	}
	public int getNumeroDoc() {
		return numeroDoc;
	}
	public void setNumeroDoc(int numeroDoc) {
		this.numeroDoc = numeroDoc;
	}
	public Tipocomprobante getTipocomprobante() {
		return tipocomprobante;
	}
	public void setTipoComprobante(Tipocomprobante tipocomprobante) {
		this.tipocomprobante = tipocomprobante;
	}	
	
}
