package daosImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import daos.CarreraDao;
import entities.Carrera;

public class CarreraDaoImpl implements CarreraDao {
	private EntityManager em;
	private static CarreraDaoImpl CarreraDaoImpl;
	//private EntityManagerFactory emf;
	
	private CarreraDaoImpl(EntityManager em) {
		//this.emf = Persistence.createEntityManagerFactory("Entregable3");
		this.em = em;
		CarreraDaoImpl = null;
	}
	
	public Carrera addCarrera (Carrera c) {
		em.getTransaction().begin();
		TypedQuery<Carrera> query = em.createQuery("SELECT c FROM Carrera c WHERE nombre = ?1", Carrera.class);
			query.setParameter(1,c.getNombre());
			List<Carrera> resultados = query.getResultList();
			@SuppressWarnings("unused")
			Carrera existeCarrera = null;
			if (!resultados.isEmpty()) {
				return existeCarrera = (Carrera) resultados.get(0);
			}
		    em.persist(c);
		    this.em.getTransaction().commit();
			return c;		
	}
	
	public Carrera getCarrera (int id) {
		Carrera e = em.find(Carrera.class,id);
		return e;
	}
	
	
	public List<Carrera> getCarrerasCantInscriptos() {
		TypedQuery<Carrera> query = em.createQuery("SELECT c FROM Carrera c WHERE c.cantInscriptos > 0 ORDER BY cantInscriptos ASC", Carrera.class);
		List<Carrera> carreras = query.getResultList();
		return carreras;
	}
	
	
	public List<Carrera> getReporteCarreras() {
		TypedQuery<Carrera> query = em.createQuery("SELECT c FROM Carrera c JOIN Registro r ON (c.id = r.carrera) JOIN Estudiante e ON (e.libreta = r.estudiante and e.libreta = r.estudiante) ORDER BY c.nombre, r.inscripcion", Carrera.class);
		List<Carrera> carreras = query.getResultList();
		return carreras;
	}

	@Override
	public CarreraDaoImpl getInstance(EntityManager em) {//chequear em
		if (CarreraDaoImpl == null) {
			return new CarreraDaoImpl(em);
		} else {
			return CarreraDaoImpl;
		}
	}
}
