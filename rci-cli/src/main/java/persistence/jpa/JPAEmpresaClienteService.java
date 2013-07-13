package persistence.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.hibernate.cfg.CreateKeySecondPass;

import persistence.entity.Empresacliente;
import persistencia.servicefactory.EmpresaClienteService;

public class JPAEmpresaClienteService implements EmpresaClienteService{

	@Override
	public void insertarEmpresaCliente(Empresacliente empresacliente) {
		// TODO Auto-generated method stub
		EntityManager em = JPAUtil.getEntityManager();
		try{
			em.getTransaction().begin();
			em.persist(empresacliente);
			em.getTransaction().commit();
		}
		finally{
			em.close();
		}	
		
		
	}

	@Override
	public List<Empresacliente> listarEmpresaCliente() {
		// TODO Auto-generated method stub
		EntityManager em=JPAUtil.getEntityManager();
		try{
			String query="SELECT ec FROM empresacliente ec ORDER BY ec.id";
			TypedQuery<Empresacliente> emquery=em.createQuery(query, Empresacliente.class);
			return emquery.getResultList();
		}finally{
			em.close();
		}
		
		
	}

}
