package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author Pedro Alex
 */
public class HibernateUtil {

	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistence");

	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

}
