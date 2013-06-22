package persistence.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import persistence.entidades.Image;
import persistence.service.ImageService;

public class JPAImageService implements ImageService {

	@Override
	public void insertar(Image imagen) {
		EntityManager em = JPAUtil.getEntityManager();
		try{
			em.getTransaction().begin();
			em.persist(imagen);
			em.getTransaction().commit();			
		}
		finally{
			em.close();
		}		
	}

	@Override
	public void actualizar(Image imagen) {
	    EntityManager em = JPAUtil.getEntityManager();
		try{
			em.getTransaction().begin();
			em.merge(imagen);
			em.getTransaction().commit();
		}
		finally{
			em.close();
		}
	}

	@Override
	public void eliminar(Image imagen) {
		EntityManager em = JPAUtil.getEntityManager();
		try{
			em.getTransaction().begin();
			em.remove(imagen);
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
	public List<Image> listarImage() {
		EntityManager em = JPAUtil.getEntityManager();
		try{
			String query = "SELECT i from Image i ORDER BY i.id";
			TypedQuery<Image> emquery = em.createQuery(query, Image.class);
			return emquery.getResultList();			
		}
		finally{
			em.close();			
		}	
	}

	@Override
	public Image obtenerPorId(int id) {
		EntityManager em = JPAUtil.getEntityManager();
		try{
			String query = "SELECT i from Image i WHERE i.id=:id ORDER BY i.id";
			TypedQuery<Image> emquery = em.createQuery(query, Image.class);
			emquery.setParameter("id", id);
			return emquery.getSingleResult();			
		}
		finally{
			em.close();			
		}	
	}

	

}
