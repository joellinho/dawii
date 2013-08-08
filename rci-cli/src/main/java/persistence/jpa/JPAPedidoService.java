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
			// Buscamos el anterior
			em.getTransaction().begin();
			String query="SELECT p FROM Pedido p where p.ultimopedido=1";
			TypedQuery<Pedido> emquery=em.createQuery(query, Pedido.class);
			emquery.setMaxResults(1);
			List<Pedido> lista = emquery.getResultList();
			if(lista.size()>0){
				Pedido pedidoAnterior = lista.get(0);
				pedidoAnterior.setUltimopedido((byte)0x00);
				em.merge(pedidoAnterior);
			}
			
			// Insertamos el nuevo
			pedido.setUltimopedido((byte)0x01);
			
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
			String query="SELECT p FROM Pedido p";
			TypedQuery<Pedido> emquery=em.createQuery(query, Pedido.class);
			
			return emquery.getResultList();
		}finally{
			em.close();
		}
		
		
	}


}
