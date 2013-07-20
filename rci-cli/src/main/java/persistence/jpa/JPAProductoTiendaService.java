package persistence.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import persistence.entity.Productotienda;
import persistence.entity.Tienda;
import persistence.entity.Ubigeo;
import persistencia.servicefactory.ProductoTiendaService;

public class JPAProductoTiendaService implements ProductoTiendaService {

	@Override
	public List<Productotienda> listarProductoTiendaPorTienda(Tienda tienda) {
		EntityManager em = JPAUtil.getEntityManager();
		try{
			String query = "SELECT pt FROM Produtotienda pt WHERE pt.tienda=:tienda";
			TypedQuery<Productotienda> emquery = em.createQuery(query,Productotienda.class);
			emquery.setParameter("tienda", tienda);
			return emquery.getResultList();
		}
		finally{
			em.close();
		}
	}

	@Override
	public List<Productotienda> listarProductoTiendaEnTiendas(
			List<Tienda> tiendas) {
		EntityManager em = JPAUtil.getEntityManager();
		try{
			String query = "SELECT pt FROM Productotienda pt WHERE pt.tienda in :tiendas";
			TypedQuery<Productotienda> emquery = em.createQuery(query,Productotienda.class);
			emquery.setParameter("tiendas", tiendas);
			return emquery.getResultList();
		}
		finally{
			em.close();
		}	
	}

}
