package persistence.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import persistence.entity.Tienda;
import persistence.entity.Ubigeo;
import persistence.servicefactory.TiendaService;

public class JPATiendaService implements TiendaService{

	@Override
	public List<Tienda> obtenerTiendasUbigeo(Ubigeo ubi) {
		EntityManager em=JPAUtil.getEntityManager();
		try{
			String query="SELECT t FROM Tienda t where t.ubigeo=:ubigeo";
			TypedQuery<Tienda> emquery=em.createQuery(query, Tienda.class);
			emquery.setParameter("ubigeo", ubi);
			return emquery.getResultList();
		}finally{
			em.close();
		}
	}

	@Override
	public Tienda obtenerTiendaPorId(int id) {
		EntityManager em=JPAUtil.getEntityManager();
		try{
			String query="SELECT t FROM Tienda t where t.id=:id";
			TypedQuery<Tienda> emquery=em.createQuery(query, Tienda.class);
			emquery.setParameter("id", id);
			emquery.setMaxResults(1);
			List<Tienda> resultList = emquery.getResultList();
			if(resultList.size()>0){
				return resultList.get(0);
			}
			else{
				return null;
			}
			
		}finally{
			em.close();
		}
	}

}
