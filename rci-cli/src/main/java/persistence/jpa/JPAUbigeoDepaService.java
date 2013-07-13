package persistence.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import persistence.entity.UbigeoDepa;
import persistencia.servicefactory.UbigeoDepaService;

public class JPAUbigeoDepaService implements UbigeoDepaService {

	@Override
	public List<UbigeoDepa> listarUbigeoDepa() {
		EntityManager em = JPAUtil.getEntityManager();
		try{
			String query = "SELECT ud FROM UbigeoDepa ud";
			TypedQuery<UbigeoDepa> emquery = em.createQuery(query,UbigeoDepa.class);
			return emquery.getResultList();
		}
		finally{
			em.close();
		}
	}

}
