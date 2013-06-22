package persistence.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import persistence.entidades.Pedido;
import persistence.service.ProductoTiendaService;

public class JPAProductoTiendaService implements ProductoTiendaService {

	@Override
	public void insertar(Pedido pedido) {
		EntityManager em = JPAUtil.getEntityManager();
		try{
			em.getTransaction().begin();
			em.persist(pedido);
			em.getTransaction().commit();
		}
		finally{
			em.close();
		}
	}

	@Override
	public void actualizar(Pedido pedido) {
		EntityManager em = JPAUtil.getEntityManager();
		try{
			em.getTransaction().begin();
			em.merge(pedido);
			em.getTransaction().commit();
		}
		finally{
			em.close();
		}
	}

	@Override
	public void eliminar(Pedido pedido) {
		EntityManager em = JPAUtil.getEntityManager();
		try{
			em.getTransaction().begin();
			em.remove(pedido);
			em.getTransaction().commit();
		}
		finally{
			em.close();
		}
	}

	@Override
	public List<Pedido> listarPedido() {
		EntityManager em = JPAUtil.getEntityManager();
		try{
			String query = "SELECT p from Pedido p ORDER BY p.id";
			TypedQuery<Pedido> emquery = em.createQuery(query,Pedido.class);
			return emquery.getResultList();
		}
		finally{
			em.close();
		}
	}

	@Override
	public Pedido obtenerPorId(int id) {
		EntityManager em = JPAUtil.getEntityManager();
		try{
			String query = "SELECT p from Pedido d WHERE p.id=:id ORDER BY p.id";
			TypedQuery<Pedido> emquery = em.createQuery(query,Pedido.class);
			emquery.setParameter("id", id);
			return emquery.getSingleResult();
		}
		finally{
			em.close();
		}
	}

}
