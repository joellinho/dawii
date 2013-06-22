package persistence.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import persistence.entidades.CategoriaProducto;
import persistence.service.CategoriaProductoService;

public class JPACategoriaProductoService implements CategoriaProductoService {

	@Override
	public void insertar(CategoriaProducto categoria) {
		EntityManager em = JPAUtil.getEntityManager();
		try{
			em.getTransaction().begin();
			em.persist(categoria);
			em.getTransaction().commit();			
		}
		finally{
			em.close();
		}	
	}

	@Override
	public void actualizar(CategoriaProducto categoria) {
		EntityManager em = JPAUtil.getEntityManager();
		try{
			em.getTransaction().begin();
			em.merge(categoria);
			em.getTransaction().commit();
		}
		finally{
			em.close();
		}
	}

	@Override
	public void eliminar(CategoriaProducto categoria) {
		EntityManager em = JPAUtil.getEntityManager();
		try{
			em.getTransaction().begin();
			em.remove(categoria);
			em.getTransaction().commit();
		}
		finally{
			em.close();			
		}	
	}

	@Override
	public List<CategoriaProducto> listarCategoriaProducto() {
		EntityManager em = JPAUtil.getEntityManager();
		try{
			String query = "SELECT c from CategoriaProducto c ORDER BY c.id";
			TypedQuery<CategoriaProducto> emquery = em.createQuery(query,CategoriaProducto.class);
			return emquery.getResultList();
		}
		finally{
			em.close();			
		}	
	}

	@Override
	public CategoriaProducto obtenerPorId(int id) {
		EntityManager em = JPAUtil.getEntityManager();
		try{
			String query = "SELECT c from CategoriaProducto c WHERE c.id=:id ORDER BY c.id";
			TypedQuery<CategoriaProducto> emquery = em.createQuery(query,CategoriaProducto.class);
			emquery.setParameter("id", id);
			return emquery.getSingleResult();
		}
		finally{
			em.close();			
		}		
	}

}
