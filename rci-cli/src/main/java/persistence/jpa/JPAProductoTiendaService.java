package persistence.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import persistence.entidades.ProductoTienda;
import persistence.service.ProductoTiendaService;

public class JPAProductoTiendaService implements ProductoTiendaService {

	@Override
	public void insertar(ProductoTienda producto) {
		EntityManager em = JPAUtil.getEntityManager();
		try{
			em.getTransaction().begin();
			em.persist(producto);
			em.getTransaction().commit();
		}
		finally{
			em.close();
		}
	}

	@Override
	public void actualizar(ProductoTienda producto) {
		EntityManager em = JPAUtil.getEntityManager();
		try{
			em.getTransaction().begin();
			em.merge(producto);
			em.getTransaction().commit();
		}
		finally{
			em.close();
		}
	}

	@Override
	public void eliminar(ProductoTienda producto) {
		EntityManager em = JPAUtil.getEntityManager();
		try{
			em.getTransaction().begin();
			em.remove(producto);
			em.getTransaction().commit();
		}
		finally{
			em.close();
		}
	}

	@Override
	public List<ProductoTienda> listarProducto() {
		EntityManager em = JPAUtil.getEntityManager();
		try{
			String query = "SELECT p from Pedido p ORDER BY p.id";
			TypedQuery<ProductoTienda> emquery = em.createQuery(query,ProductoTienda.class);
			return emquery.getResultList();
		}
		finally{
			em.close();
		}
	}

	@Override
	public ProductoTienda obtenerPorId(int id) {
		EntityManager em = JPAUtil.getEntityManager();
		try{
			String query = "SELECT p from ProductoTienda p WHERE p.id=:id ORDER BY p.id";
			TypedQuery<ProductoTienda> emquery = em.createQuery(query,ProductoTienda.class);
			emquery.setParameter("id", id);
			return emquery.getSingleResult();
		}
		finally{
			em.close();
		}
	}

}
