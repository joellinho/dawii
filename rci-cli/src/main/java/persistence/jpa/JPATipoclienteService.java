package persistence.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import persistence.entity.Tipocliente;
import persistence.servicefactory.TipoclienteService;

public class JPATipoclienteService implements TipoclienteService {

	@Override
	public void insertar(Tipocliente tipo) {
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
	public void actualizar(Tipocliente tipo) {
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
	public void eliminar(Tipocliente tipo) {
		EntityManager em = JPAUtil.getEntityManager();
		try{
			em.getTransaction().begin();
			em.remove(em.getReference(Tipocliente.class, tipo.getId()));
			em.getTransaction().commit();
		}
		finally{
			em.close();
		}	
	}

	@Override
	public List<Tipocliente> listarTipoCliente() {
		EntityManager em = JPAUtil.getEntityManager();
		try{
			String query = "SELECT tc FROM Tipocliente tc ORDER BY tc.id";
			TypedQuery<Tipocliente> emquery = em.createQuery(query,Tipocliente.class);
			return emquery.getResultList();
		}
		finally{
			em.close();
		}
	}


}
