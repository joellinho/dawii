package persistencia.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import persistencia.dao.ClienteDAO;
import persistencia.entidades.Cliente;

public class JPAClienteDAO implements ClienteDAO {

	private EntityManager em = HibernateUtil.getEntityManager();
	
	@Override
	public void insertar(Cliente cliente) {
		
		try{
			em.getTransaction().begin();
			em.persist(cliente);
			em.flush();
			em.getTransaction().commit();			
		}
		finally{
			em.close();
		}		
	}

	@Override
	public void actualizar(Cliente cliente) {
		try{
			em.getTransaction().begin();
			/*
			Esto deberia fallar
			*/
			em.merge(cliente);
			em.flush(); 
			em.getTransaction().commit();
		}
		finally{
			em.close();
		}
	}

	@Override
	public void eliminar(Cliente cliente) {
		try{
			em.getTransaction().begin();
			em.remove(cliente);
			/*
			 * Deberia fallar
			 */
			em.flush(); 
			em.getTransaction().commit();
		}
		finally{
			em.close();			
		}		
	}

	@Override
	public List<Cliente> listarClientes() {
		List<Cliente> listaEntidad;
		try{
			String query = "SELECT c from Cliente c ORDER BY c.id";
			Query emquery = em.createQuery(query);
			listaEntidad = emquery.getResultList();
			return listaEntidad;
		}
		finally{
			em.close();			
		}		
	}

	@Override
	public Cliente obtenerPorId(int id) {
		List<Cliente> listaEntidad;
		try{
			String query = "SELECT c from Cliente c ORDER BY c.id";
			Query emquery = em.createQuery(query);
			emquery.setParameter("id", id);
			listaEntidad = emquery.getResultList();			
			if(listaEntidad.size()>0){
				return listaEntidad.get(0);
			}
			else{
				return null;
			}
		}
		finally{
			em.close();			
		}		
	}


}
