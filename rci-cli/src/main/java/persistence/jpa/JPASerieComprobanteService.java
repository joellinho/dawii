package persistence.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import persistence.entity.Pedido;
import persistence.entity.SerieComprobante;
import persistence.entity.Tipocomprobante;
import persistence.servicefactory.SerieComprobanteService;

public class JPASerieComprobanteService implements SerieComprobanteService{

	@Override
	public SerieComprobante obtenerSerieParaComprobante(Tipocomprobante tipo) {
		// TODO Auto-generated method stub
		EntityManager em=JPAUtil.getEntityManager();
		try{
			String query="SELECT sc FROM SerieComprobante sc " + 
						 "WHERE sc.tipocomprobante = :tipo " +
						 "ORDER BY sc.fechaReg DESC";
			TypedQuery<SerieComprobante> emquery=em.createQuery(query, SerieComprobante.class);
			emquery.setParameter("tipo", tipo);
			List<SerieComprobante> resultList = emquery.getResultList();
			if(resultList.size()>0){
				return resultList.get(0);
			}
			else{
				return null;
			}
		}finally{
			em.close();
		}
	}

}
