package persistence.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import persistence.entity.Cliente;
import persistence.entity.Empresacomercial;
import persistence.servicefactory.EmpresacomercialService;

public class JPAEmpresaComercialService implements EmpresacomercialService {

	@Override
	public List<Empresacomercial> listarConProductos() {
		EntityManager em = JPAUtil.getEntityManager();
		try{
			String query = "SELECT ec FROM Empresacomercial ec ORDER BY ec.id";
			TypedQuery<Empresacomercial> emquery = em.createQuery(query,Empresacomercial.class);
			List<Empresacomercial> resultado = emquery.getResultList();
			for(Empresacomercial ec : resultado){
				ec.getProductoempresas();
			}
			return resultado;
		}
		finally{
			em.close();
		}
	}

}
