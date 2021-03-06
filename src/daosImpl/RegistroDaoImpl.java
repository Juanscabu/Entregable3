package daosImpl;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import daos.RegistroDao;
import entities.Carrera;
import entities.Estudiante;
import entities.Registro;

public class RegistroDaoImpl implements RegistroDao {

private EntityManager em;
private static RegistroDaoImpl registroDaoImpl;
	
	private RegistroDaoImpl(EntityManager em) {
		this.em = em;
		registroDaoImpl = null;
	}
	
	public Registro matricularEstudiante(Estudiante e, Carrera c, int a) {
			Registro r = new Registro();
		 	Carrera c1 = em.find(Carrera.class,c.getId());
		 	Estudiante e1 = em.find(Estudiante.class,e.getLibreta());
		 	Registro r1 = new Registro(e,c,a);
		 	r1 = em.find(Registro.class,r1);
		 	if (c1 != null && e1 != null && r1 == null) {
		 	Query query = em.createQuery("UPDATE Carrera c SET c.cantInscriptos = c.cantInscriptos+1 WHERE id=?1");
		 	query.setParameter(1,c.getId());
		 	query.executeUpdate();
			r = new Registro (e,c,a);
		    em.persist(r);
		    em.getTransaction().commit();
			em.clear();
		    return r;
		 	}
		 return r;
	}

	public static RegistroDaoImpl getInstance(EntityManager em) {
		if (registroDaoImpl == null) {
			registroDaoImpl = new RegistroDaoImpl(em);
		}
		return registroDaoImpl;
	}
}
