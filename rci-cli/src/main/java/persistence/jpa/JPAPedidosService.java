package persistence.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import persistence.entity.Pedido;
import persistence.servicefactory.PedidosService;

public class JPAPedidosService  implements PedidosService{

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
