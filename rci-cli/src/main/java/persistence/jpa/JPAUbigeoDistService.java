package persistence.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import persistence.entity.UbigeoDist;

public class JPAUbigeoDistService implements
		persistencia.servicefactory.UbigeoDistService {

	@Override
	public List<UbigeoDist> listarUbigeoDist() {
		EntityManager em = JPAUtil.getEntityManager();
		try{
			String query = "SELECT ud FROM UbigeoDist ud";
			TypedQuery<UbigeoDist> emquery = em.createQuery(query,UbigeoDist.class);
			return emquery.getResultList();
		}
		finally{
			em.close();
		}
	}

	@Override
	public void insertar(UbigeoDist ubigeoDist) {
		EntityManager em = JPAUtil.getEntityManager();
		try{
			em.getTransaction().begin();
			em.persist(ubigeoDist);
			em.getTransaction().commit();
		}
		finally{
			em.close();
		}	
	}

	@Override
	public UbigeoDist obtenerPorId(String id) {
		EntityManager em=JPAUtil.getEntityManager();
		return em.getReference(UbigeoDist.class, id);
	}

}
