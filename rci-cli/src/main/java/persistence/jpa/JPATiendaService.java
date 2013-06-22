package persistence.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import persistence.entidades.Tienda;
import persistence.service.TiendaService;

public class JPATiendaService implements TiendaService {

	@Override
	public void insertar(Tienda tienda) {
		EntityManager em = JPAUtil.getEntityManager();
		try{
			em.getTransaction().begin();
			em.persist(tienda);
			em.getTransaction().commit();
		}
		finally{
			em.close();
		}
	}

	@Override
	public void actualizar(Tienda tienda) {
		EntityManager em = JPAUtil.getEntityManager();
		try{
			em.getTransaction().begin();
			em.merge(tienda);
			em.getTransaction().commit();
		}
		finally{
			em.close();
		}
	}

	@Override
	public void eliminar(Tienda tienda) {
		EntityManager em = JPAUtil.getEntityManager();
		try{
			em.getTransaction().begin();
			em.remove(tienda);
			em.getTransaction().commit();
		}
		finally{
			em.close();
		}
	}

	@Override
	public List<Tienda> listarTienda() {
		EntityManager em = JPAUtil.getEntityManager();
		try{
			String query = "SELECT t from Tienda t ORDER BY t.id";
			TypedQuery<Tienda> emquery = em.createQuery(query,Tienda.class);
			return emquery.getResultList();
		}
		finally{
			em.close();
		}
	}

	@Override
	public Tienda obtenerPorId(int id) {
		EntityManager em = JPAUtil.getEntityManager();
		try{
			String query = "SELECT t from Tienda t WHERE t.id = :id ORDER BY t.id";
			TypedQuery<Tienda> emquery = em.createQuery(query, Tienda.class);
			emquery.setParameter("id", id);
			return emquery.getSingleResult();	
		}
		finally{
			em.close();
		}
	}

}
