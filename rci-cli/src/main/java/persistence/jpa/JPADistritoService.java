package persistence.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import persistence.entidades.Distrito;
import persistence.service.DistritoService;

public class JPADistritoService implements DistritoService {
	
	@Override
	public void insertar(Distrito distrito) {
		EntityManager em = JPAUtil.getEntityManager();
		try{
			em.getTransaction().begin();
			em.persist(distrito);
			em.getTransaction().commit();			
		}
		finally{
			em.close();
		}		
	}

	@Override
	public void actualizar(Distrito distrito) {
		EntityManager em = JPAUtil.getEntityManager();
		try{
			em.getTransaction().begin();
			em.merge(distrito);
			em.getTransaction().commit();
		}
		finally{
			em.close();
		}
	}

	@Override
	public void eliminar(Distrito distrito) {
		EntityManager em = JPAUtil.getEntityManager();
		try{
			em.getTransaction().begin();
			em.remove(distrito);
			em.getTransaction().commit();
		}
		finally{
			em.close();			
		}		
	}

	@Override
	public List<Distrito> listarDistrito() {
		EntityManager em = JPAUtil.getEntityManager();
		try{
			String query = "SELECT d from Distrito d ORDER BY d.id";
			TypedQuery<Distrito> emquery = em.createQuery(query,Distrito.class);
			return emquery.getResultList();
		}
		finally{
			em.close();			
		}		
	}

	@Override
	public Distrito obtenerPorId(int id) {
		EntityManager em = JPAUtil.getEntityManager();
		try{
			String query = "SELECT d from Distrito d WHERE d.id=:id ORDER BY d.id";
			TypedQuery<Distrito> emquery = em.createQuery(query,Distrito.class);
			emquery.setParameter("id", id);
			return emquery.getSingleResult();
		}
		finally{
			em.close();			
		}		
	}

}
