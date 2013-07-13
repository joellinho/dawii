package persistence.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import persistence.entity.Ubigeo;
import persistencia.servicefactory.UbigeoService;

public class JPAUbigeoService implements UbigeoService {

	@Override
	public List<Ubigeo> listarUbigeo() {
		EntityManager em = JPAUtil.getEntityManager();
		try{
			String query = "SELECT u FROM Ubigeo u";
			TypedQuery<Ubigeo> emquery = em.createQuery(query,Ubigeo.class);
			return emquery.getResultList();
		}
		finally{
			em.close();
		}
	}

}
