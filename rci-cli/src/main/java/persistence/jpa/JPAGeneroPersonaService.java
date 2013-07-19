package persistence.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import persistence.entity.Cliente;
import persistence.entity.Generopersona;
import persistencia.servicefactory.GeneroPersonaService;

public class JPAGeneroPersonaService implements GeneroPersonaService{

	@Override
	public void insertarGenero(Generopersona genero) {
		// TODO Auto-generated method stub
		EntityManager em = JPAUtil.getEntityManager();
		try{
			em.getTransaction().begin();
			em.persist(genero);
			em.getTransaction().commit();
		}
		finally{
			em.close();
		}	
	}

	@Override
	public List<Generopersona> listarGenero() {
		// TODO Auto-generated method stub
		EntityManager em=JPAUtil.getEntityManager();
		try{
			String query ="SELECT gp FROM GeneroPersona gp ORDER BY gp.id";
			TypedQuery<Generopersona> emquery=em.createQuery(query, Generopersona.class);
			return emquery.getResultList();
		}finally{
			em.close();
		}
				
	}

	@Override
	public Generopersona findById(int id) {
		EntityManager em=JPAUtil.getEntityManager();
		return em.getReference(Generopersona.class, id);
	}

}
