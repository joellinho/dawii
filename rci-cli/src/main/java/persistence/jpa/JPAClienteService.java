package persistence.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import persistence.entity.Cliente;
import persistencia.servicefactory.ClienteService;

public class JPAClienteService implements ClienteService {

	@Override
	public void insertar(Cliente cliente) {
		EntityManager em = JPAUtil.getEntityManager();
		try{
			em.getTransaction().begin();
			em.persist(cliente);
			em.getTransaction().commit();
		}
		finally{
			em.close();
		}	
	}

	@Override
	public void actualizar(Cliente cliente) {
		EntityManager em = JPAUtil.getEntityManager();
		try{
			em.getTransaction().begin();
			em.merge(cliente);
			em.getTransaction().commit();
		}
		finally{
			em.close();
		}	
	}

	@Override
	public void eliminar(Cliente cliente) {
		EntityManager em = JPAUtil.getEntityManager();
		try{
			em.getTransaction().begin();
			em.remove(cliente);
			em.getTransaction().commit();
		}
		finally{
			em.close();
		}	
	}

	@Override
	public List<Cliente> listarClientes() {
		EntityManager em = JPAUtil.getEntityManager();
		try{
			String query = "SELECT c FROM Cliente c ORDER BY c.id";
			TypedQuery<Cliente> emquery = em.createQuery(query,Cliente.class);
			return emquery.getResultList();
		}
		finally{
			em.close();
		}
	}

}
