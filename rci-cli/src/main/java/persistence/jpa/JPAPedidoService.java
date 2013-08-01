package persistence.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import persistence.entity.Pedido;
import persistence.servicefactory.PedidoService;

public class JPAPedidoService implements PedidoService {

	@Override
	public void insertarPedido(Pedido pedido) {
		EntityManager em = JPAUtil.getEntityManager();
		try{
			em.getTransaction().begin();
			em.persist(pedido);
			em.getTransaction().commit();
		}
		catch(Exception e) {
			em.getTransaction().rollback();
			throw e;
		}
		finally{
			em.close();
		}
	}
	
	@Override
	public List<Pedido> listarPedidos() {
		// TODO Auto-generated method stub
		EntityManager em=JPAUtil.getEntityManager();
		try{
			String query="SELECT p FROM pedido p";
			TypedQuery<Pedido> emquery=em.createQuery(query, Pedido.class);
			
			return emquery.getResultList();
		}finally{
			em.close();
		}
		
		
	}


}
