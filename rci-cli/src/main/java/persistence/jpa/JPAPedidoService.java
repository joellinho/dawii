package persistence.jpa;

import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import persistence.entity.Facturacion;
import persistence.entity.Pedido;
import persistence.entity.SerieComprobante;
import persistence.entity.Tipocomprobante;
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
			
			// Ahora antes de insertar el pedido debemos obtener el siguiente código para la factura
			// solo si existe facutra
			if(pedido.getFacturacions()!=null)
			{
				for(Facturacion fact : pedido.getFacturacions()){
					SerieComprobante sc = this.obtenerSerieFacturaActual(em,fact.getTipocomprobante());
					if(sc!=null){
						// Si encontramos la siguiente serie, la usamos, aumentamos y guardamos
						fact.setId(String.format("%03d", sc.getSerieDoc()) + 
								   "-" +
								   String.format("%06d", sc.getNumeroDoc()));
						sc.setNumeroDoc(sc.getNumeroDoc() + 1);
						em.persist(sc);
					}
					else{
						// Si no hay serie uso un guid (deberia ser null si la serie no fuera el pk)
						fact.setId(UUID.randomUUID().toString());
					}
				}
			}
			
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
	
	private SerieComprobante obtenerSerieFacturaActual(EntityManager em, Tipocomprobante tipo)
	{
		String query="SELECT sc FROM SerieComprobante sc " + 
				 "WHERE sc.tipocomprobante = :tipo " +
				 "ORDER BY sc.fechaReg DESC";
		TypedQuery<SerieComprobante> emquery=em.createQuery(query, SerieComprobante.class);
		emquery.setParameter("tipo", tipo);
		List<SerieComprobante> resultList = emquery.getResultList();
		if(resultList.size()>0){
			return resultList.get(0);
		}
		else{
			return null;
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
