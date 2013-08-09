package persistence.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import persistence.entity.Productoempresa;
import persistence.servicefactory.ProductoEmpresaService;

public class JPAProductoEmpresaService implements ProductoEmpresaService {

	@Override
	public List<Productoempresa> listarProductoEmpresa() {
		EntityManager em=JPAUtil.getEntityManager();
		try{
			String query="SELECT pe FROM Productoempresa pe ORDER BY pe.empresacomercial.id";
			TypedQuery<Productoempresa> emquery=em.createQuery(query, Productoempresa.class);
			return emquery.getResultList();
		}finally{
			em.close();
		}
	}

}
