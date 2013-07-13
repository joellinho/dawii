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

}
