package sistema;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import controllers.CarreraController;
import controllers.EstudianteController;
import controllers.RegistroController;

public class Sistema {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Example");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		EstudianteController e1 = new EstudianteController(/*em*/);
		CarreraController c1 = new CarreraController(em);
		RegistroController r1 = new RegistroController(em);
		
		em.getTransaction().commit();
		em.close();
		emf.close();
	}

}
