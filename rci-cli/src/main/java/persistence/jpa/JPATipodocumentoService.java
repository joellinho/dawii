package persistence.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import persistence.entity.Generopersona;
import persistence.entity.Tipodocumento;
import persistencia.servicefactory.TipodocumentoService;

public class JPATipodocumentoService implements TipodocumentoService {

	@Override
	public void insertar(Tipodocumento tipo) {
		EntityManager em = JPAUtil.getEntityManager();
		try{
			em.getTransaction().begin();
			em.persist(tipo);
			em.getTransaction().commit();
		}
		finally{
			em.close();
		}	
	}

	@Override
	public void actualizar(Tipodocumento tipo) {
		EntityManager em = JPAUtil.getEntityManager();
		try{
			em.getTransaction().begin();
			em.merge(tipo);
			em.getTransaction().commit();
		}
		finally{
			em.close();
		}	
	}

	@Override
	public void eliminar(Tipodocumento tipo) {
		EntityManager em = JPAUtil.getEntityManager();
		try{
			em.getTransaction().begin();
			em.remove(em.getReference(Tipodocumento.class, tipo.getId()));
			em.getTransaction().commit();
		}
		finally{
			em.close();
		}	
	}

	@Override
	public List<Tipodocumento> listarDocumento() {
		EntityManager em = JPAUtil.getEntityManager();
		try{
			String query = "SELECT t FROM Tipodocumento t ORDER BY t.id";
			TypedQuery<Tipodocumento> emquery = em.createQuery(query,Tipodocumento.class);
			return emquery.getResultList();
		}
		finally{
			em.close();
		}
	}

	@Override
	public Tipodocumento findById(int id) {
		EntityManager em=JPAUtil.getEntityManager();
		return em.getReference(Tipodocumento.class, id);
	}

}
