package persistencia.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import persistencia.entidades.TipoCliente;
import persistencia.service.TipoClienteService;

public class JPATipoClienteService implements TipoClienteService{
	

	@Override
	public void insertar(TipoCliente tipoCliente) {
		EntityManager em = JPAUtil.getEntityManager();
		try{
			em.getTransaction().begin();
			em.persist(tipoCliente);
			em.flush();
			em.getTransaction().commit();	
		}
		finally{
			em.close();
		}
		
	}

	@Override
	public void actualizar(TipoCliente tipoCliente) {
		EntityManager em = JPAUtil.getEntityManager();
		try{
			em.getTransaction().begin();
			em.merge(tipoCliente);
			em.getTransaction().commit();
		}
		finally{
			em.close();
		}
	}

	@Override
	public void eliminar(TipoCliente tipoCliente) {
		EntityManager em = JPAUtil.getEntityManager();
		try{
			em.getTransaction().begin();
			em.remove(tipoCliente);
			em.getTransaction().commit();
		}
		finally{
			em.close();
		}		
	}

	@Override
	public List<TipoCliente> listarTipoCliente() {
		EntityManager em = JPAUtil.getEntityManager();
		try{
			String query = "SELECT t from TipoCliente t ORDER BY t.id";
			TypedQuery<TipoCliente> emquery = em.createQuery(query,TipoCliente.class);
			return emquery.getResultList();
		}
		finally{
			em.close();
		}
	}

	@Override
	public TipoCliente obtenerPorId(int id) {
		EntityManager em = JPAUtil.getEntityManager();
		try{
			String query = "SELECT t from TipoCliente t WHERE t.id = :id ORDER by c.id";
			TypedQuery<TipoCliente> emquery = em.createQuery(query, TipoCliente.class);
			return emquery.getSingleResult();								
		}
		finally{
			em.close();
		}
	}

}
