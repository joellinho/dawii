package persistence.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

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

	@Override
	public Empresacliente buscarEmpresaClientePorRuc(String ruc) {
		EntityManager em=JPAUtil.getEntityManager();
		try{
			String query="SELECT ec FROM Empresacliente ec WHERE ec.ruc like :ruc";
			TypedQuery<Empresacliente> emquery=em.createQuery(query, Empresacliente.class);
			emquery.setParameter("ruc", ruc);
			List<Empresacliente> listaResultado = emquery.getResultList();
			if(listaResultado.size()<=0){
				return null;
			}
			else{
				return listaResultado.get(0);
			}
			
		}finally{
			em.close();
		}
	}

}
