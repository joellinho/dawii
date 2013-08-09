package persistence.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import persistence.entity.UbigeoProv;
import persistence.entity.UbigeoProvPK;
import persistence.servicefactory.UbigeoProvService;

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

	@Override
	public void insertar(UbigeoProv ubigeoProv) {
		EntityManager em = JPAUtil.getEntityManager();
		try{
			em.getTransaction().begin();
			em.persist(ubigeoProv);
			em.getTransaction().commit();
		}
		finally{
			em.close();
		}	
	}

	@Override
	public UbigeoProv obtenerPorId(UbigeoProvPK id) {
		EntityManager em = JPAUtil.getEntityManager();
		try{
			String query = "SELECT up FROM UbigeoProv up WHERE up.id=:id";
			TypedQuery<UbigeoProv> emquery = em.createQuery(query,UbigeoProv.class);
			emquery.setMaxResults(1);
			emquery.setParameter("id", id);
			List<UbigeoProv> resultList = emquery.getResultList(); 
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
	
	@Override
	public UbigeoProv obtenerPorId(String upcod, String udcod) {
		UbigeoProvPK id = new UbigeoProvPK();
		id.setUdCod(udcod);
		id.setUpCod(upcod);
		return this.obtenerPorId(id);
	}

	@Override
	public List<UbigeoProv> listarUbigeoProvPorDepa(String codDepa) {
		EntityManager em = JPAUtil.getEntityManager();
		try{
			String query = "SELECT up FROM UbigeoProv up WHERE up.id.udCod=:codDepa";
			TypedQuery<UbigeoProv> emquery = em.createQuery(query,UbigeoProv.class);
			emquery.setParameter("codDepa", codDepa);
			return emquery.getResultList();
		}
		finally{
			em.close();
		}
	}

	

}
