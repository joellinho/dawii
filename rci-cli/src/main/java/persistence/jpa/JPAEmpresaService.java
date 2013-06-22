package persistence.jpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import persistence.entidades.Empresa;
import persistence.service.EmpresaService;

public class JPAEmpresaService implements EmpresaService {

	@Override
	public void insertar(Empresa empresa) {
		EntityManager em = JPAUtil.getEntityManager();
		try{
			em.getTransaction().begin();
			em.persist(empresa);
			em.getTransaction().commit();
		}
		finally{
			em.close();
		}
	}

	@Override
	public void actualizar(Empresa empresa) {
		EntityManager em = JPAUtil.getEntityManager();
		try{
			em.getTransaction().begin();
			em.merge(empresa);
			em.getTransaction().commit();
		}
		finally{
			em.close();
		}
	}

	@Override
	public void eliminar(Empresa empresa) {
		EntityManager em = JPAUtil.getEntityManager();
		try{
			em.getTransaction().begin();
			em.remove(empresa);
			em.getTransaction().commit();
		}
		finally{
			em.close();
		}		
	}

	@Override
	public List<Empresa> listarEmpresa() {
		EntityManager em = JPAUtil.getEntityManager();
		try{
			String query = "SELECT e from Empresa e ORDER BY e.id";
			TypedQuery<Empresa> emquery = em.createQuery(query,Empresa.class);
			return emquery.getResultList();
		}
		finally{
			em.close();
		}
	}

	@Override
	public Empresa obtenerPorId(int id) {
		EntityManager em = JPAUtil.getEntityManager();
		try{
			String query = "SELECT e from Empresa e WHERE e.id=:id ORDER BY e.id";
			TypedQuery<Empresa> emquery = em.createQuery(query, Empresa.class);
			emquery.setParameter("id", id);
			return emquery.getSingleResult();	
		}
		finally{
			em.close();
		}
	}
	
}
