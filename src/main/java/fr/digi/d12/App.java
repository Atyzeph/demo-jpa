package fr.digi.d12;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {
    
    private static final Logger LOGGER = LoggerFactory.getLogger( App.class );
    
    public static void main( String[] args ) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory( "digi-d12" );
        EntityManager em = emf.createEntityManager();
        System.out.println(em);

        LOGGER.info( "Hello, world!!" );
//      Find
        Livre e = em.find(Livre.class,1);
        if (e != null) {
			System.out.println(e);
		}else {
			System.out.println("Non trouvé.");
		}
//      Create
        em.getTransaction().begin();
        Livre lv1 = new Livre();
        lv1.setTitre("Les fleurs sentent bon");
        lv1.setAuteur("Maurice Karem");
        em.persist(lv1);
        em.getTransaction().commit();

//		Update
        em.getTransaction().begin();
        Livre f = em.find(Livre.class,5);
        if (f != null) {
			f.setTitre("Du plaisir dans la cuisine");
	        
		}else {
			System.out.println("Non trouvé.");
		}
	    em.getTransaction().commit();
	    
//	    JPQL
        TypedQuery<Livre>query1 = em.createQuery("select f from Livre f where f.titre='Les fleurs sentent bon'", Livre.class);
        Livre f2 = query1.getResultList().get(0);
        System.out.println("Livre par titre : " + f2);
        
        TypedQuery<Livre>query2 = em.createQuery("select f from Livre f where f.auteur='Maurice Karem'", Livre.class);
        Livre f3 = query2.getResultList().get(0);
        System.out.println("Livre par auteur : " + f3);
        
//      Remove
        em.getTransaction().begin();
        Livre g = em.find(Livre.class,5);
        if (g != null) {
	        em.remove(g);
		}else {
			System.out.println("Non trouvé.");
		}
        em.getTransaction().commit();
        
//      Extract
        TypedQuery<Livre>query3 = em.createQuery("select f from Livre f", Livre.class);
        List<Livre> list1 = new ArrayList<Livre>();
        list1 = query3.getResultList();
        for (Livre lv: list1) {
        	System.out.println("LIVRE EN BDD : ");
        	System.out.println(lv.toString());
        }
        
        em.close();
        emf.close();
    }
}