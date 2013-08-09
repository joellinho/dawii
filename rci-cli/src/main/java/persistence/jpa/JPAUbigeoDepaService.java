package persistence.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import persistence.entity.UbigeoDepa;
import persistence.servicefactory.UbigeoDepaService;

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

	@Override
	public void insertar(UbigeoDepa ubigeoDepa) {
		EntityManager em = JPAUtil.getEntityManager();
		try{
			em.getTransaction().begin();
			em.persist(ubigeoDepa);
			em.getTransaction().commit();
		}
		finally{
			em.close();
		}	
	}

	@Override
	public UbigeoDepa obtenerPorId(String id) {
		EntityManager em = JPAUtil.getEntityManager();
		try{
			String query = "SELECT ud FROM UbigeoDepa ud where ud.udCod=:id ";
			TypedQuery<UbigeoDepa> emquery = em.createQuery(query,UbigeoDepa.class);
			emquery.setMaxResults(1);
			emquery.setParameter("id", id);
			List<UbigeoDepa> resultList = emquery.getResultList(); 
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
