package persistence.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import persistence.entity.UbigeoProv;
import persistencia.servicefactory.UbigeoProvService;

public class JPAUbigeoProvService implements UbigeoProvService {

	@Override
	public List<UbigeoProv> listarUbigeoProv() {
		EntityManager em = JPAUtil.getEntityManager();
		try{
			String query = "SELECT up FROM UbigeoProv up";
			TypedQuery<UbigeoProv> emquery = em.createQuery(query,UbigeoProv.class);
			return emquery.getResultList();
		}
		finally{
			em.close();
		}
	}

}
