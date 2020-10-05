package factory;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class EMF implements ServletContextListener {
	
	private static javax.persistence.EntityManagerFactory emf;
	
	@Override
	public void contextInitialized(ServletContextEvent arg) {
		emf = Persistence.createEntityManagerFactory("Entregable3");
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent arg) {
		emf.close(); 
	}
	
	public static EntityManager createEntityManager() {
		emf = Persistence.createEntityManagerFactory("Entregable3");
		return emf.createEntityManager();
	}
}
