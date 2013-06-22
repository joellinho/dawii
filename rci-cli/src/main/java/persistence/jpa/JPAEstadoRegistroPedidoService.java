package persistence.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import persistence.entidades.Cliente;
import persistence.entidades.EstadoRegistroPedido;
import persistence.entidades.EstadoRegistroPedido;
import persistence.service.EstadoRegistroPedidoService;

public class JPAEstadoRegistroPedidoService implements EstadoRegistroPedidoService {

	@Override
	public void insertar(EstadoRegistroPedido estadoRegistro) {
		EntityManager em = JPAUtil.getEntityManager();
		try{
			em.getTransaction().begin();
			em.persist(estadoRegistro);
			em.getTransaction().commit();			
		}
		finally{
			em.close();
		}		
	}

	@Override
	public void actualizar(EstadoRegistroPedido estadoRegistro) {
		EntityManager em = JPAUtil.getEntityManager();
		try{
			em.getTransaction().begin();
			em.merge(estadoRegistro);
			em.getTransaction().commit();
		}
		finally{
			em.close();
		}
	}

	@Override
	public void eliminar(EstadoRegistroPedido estadoRegistro) {
		EntityManager em = JPAUtil.getEntityManager();
		try{
			em.getTransaction().begin();
			em.remove(estadoRegistro);
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
	public List<EstadoRegistroPedido> listarEstadoRegistro() {
		EntityManager em = JPAUtil.getEntityManager();
		try{
			String query = "SELECT er from EstadoRegistro er ORDER BY c.id";
			TypedQuery<EstadoRegistroPedido> emquery = em.createQuery(query, EstadoRegistroPedido.class);
			return emquery.getResultList();			
		}
		finally{
			em.close();			
		}		
	}

	@Override
	public EstadoRegistroPedido obtenerPorId(int id) {
		EntityManager em = JPAUtil.getEntityManager();
		try{
			String query = "SELECT er from EstadoRegistroPedido er WHERE er.id=:id ORDER BY er.id";
			TypedQuery<EstadoRegistroPedido> emquery = em.createQuery(query, EstadoRegistroPedido.class);
			emquery.setParameter("id", id);
			return emquery.getSingleResult();			
		}
		finally{
			em.close();			
		}	
	}



}
