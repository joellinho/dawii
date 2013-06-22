package persistence.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class JPAUtil {
	 
	private static EntityManagerFactory emf;
 
    private static EntityManagerFactory getEntityManagerFactory() {
    	
    	if(emf==null){
    		emf=Persistence.createEntityManagerFactory("dawii");
    	}
    	return emf;    	
    }
    
    public static EntityManager getEntityManager(){
    	return getEntityManagerFactory().createEntityManager();
    }
    
    public static void clear(){
    	if(emf!=null){
    		emf.close();
    		emf = null;
    	}    	
    }  
}
