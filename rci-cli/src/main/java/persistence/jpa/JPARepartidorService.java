package persistence.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import persistence.entidades.Repartidor;
import persistence.service.RepartidorService;

public class JPARepartidorService implements RepartidorService {

	@Override
	public void insertar(Repartidor repartidor) {
		EntityManager em = JPAUtil.getEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(repartidor);
			em.getTransaction().commit();
		} finally{
			em.close();
		}
	}

	@Override
	public void actualizar(Repartidor repartidor) {
		EntityManager em = JPAUtil.getEntityManager();
		try{
			em.getTransaction().begin();
			em.merge(repartidor);
			em.getTransaction().commit();
		}
		finally{
			em.close();
		}
	}

	@Override
	public void eliminar(Repartidor repartidor) {
		EntityManager em = JPAUtil.getEntityManager();
		try{
			em.getTransaction().begin();
			em.remove(repartidor);
			/*
			Esto deberia fallar, es necesario obtener el objeto de nuevo
			ya que el em al que pertenece el objeto probablemente expiro
			*/
			em.getTransaction().commit();
		}
		finally{
			em.close();			
		}		
	}

	@Override
	public List<Repartidor> listarRepartidor() {
		EntityManager em = JPAUtil.getEntityManager();
		try{
			String query = "SELECT r from Repartidor r ORDER BY e.id";
			TypedQuery<Repartidor> emquery = em.createQuery(query, Repartidor.class);
			return emquery.getResultList();			
		}
		finally{
			em.close();			
		}		
	}

	@Override
	public Repartidor obtenerPorId(int id) {
		EntityManager em = JPAUtil.getEntityManager();
		try{
			String query = "SELECT r from Repartidor r WHERE r.id=:id ORDER BY r.id";
			TypedQuery<Repartidor> emquery = em.createQuery(query, Repartidor.class);
			emquery.setParameter("id", id);
			return emquery.getSingleResult();			
		}
		finally{
			em.close();			
		}	
	}

}
