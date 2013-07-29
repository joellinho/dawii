package persistence.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import persistence.entity.Ubigeo;
import persistence.servicefactory.UbigeoService;

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

	@Override
	public Ubigeo obtenerUbigeo(String codDistrito) {
		EntityManager em = JPAUtil.getEntityManager();
		try{
			String query = "SELECT u FROM Ubigeo u WHERE u.codDis=:codDistrito";
			TypedQuery<Ubigeo> emquery = em.createQuery(query,Ubigeo.class);			
			emquery.setMaxResults(1);
			emquery.setParameter("codDistrito", codDistrito);
			List<Ubigeo> resultList = emquery.getResultList(); 
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
