package persistence.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import persistence.entity.Generopersona;
import persistence.entity.Tipocomprobante;
import persistence.entity.Tipodocumento;
import persistence.entity.UbigeoDist;
import persistence.servicefactory.TipocomprobanteService;

public class JPATipocomprobanteService implements TipocomprobanteService {

	@Override
	public void insertar(Tipocomprobante tipo) {
		// TODO Auto-generated method stub
		EntityManager em = JPAUtil.getEntityManager();
		try{
			em.getTransaction().begin();
			em.persist(tipo);
			em.getTransaction().commit();
		}
		finally{
			em.close();
		}	
	}

	@Override
	public List<Tipocomprobante> listarComprobantes() {
		// TODO Auto-generated method stub
		EntityManager em=JPAUtil.getEntityManager();
		try{
			String query ="SELECT tc FROM Tipocomprobante tc";
			TypedQuery<Tipocomprobante> emquery=em.createQuery(query, Tipocomprobante.class);
			return emquery.getResultList();
		}finally{
			em.close();
		}
	}

	@Override
	public Tipocomprobante findById(int id) {
		EntityManager em = JPAUtil.getEntityManager();
		try{
			String query = "SELECT tc FROM Tipocomprobante tc WHERE tc.id=:id";
			TypedQuery<Tipocomprobante> emquery = em.createQuery(query,Tipocomprobante.class);
			emquery.setMaxResults(1);
			emquery.setParameter("id", id);
			List<Tipocomprobante> resultList = emquery.getResultList(); 
			if(resultList.size()>0){
				return resultList.get(0);
			}
			else{
				return null;
			}		
		}
		finally{
			em.close();
		}
	}

}
