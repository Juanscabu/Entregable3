package daosImpl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import daos.EstudianteDao;
import entities.Carrera;
import entities.Estudiante;

public class EstudianteDaoImpl implements EstudianteDao {
	private EntityManager em;
	private static EstudianteDaoImpl estudianteDaoImpl;

	private EstudianteDaoImpl(EntityManager em) {
		this.em = em;
		estudianteDaoImpl = null;
	}

	public Estudiante addEstudiante (Estudiante e) {
		em.getTransaction().begin();
		TypedQuery<Estudiante> query = em.createQuery("SELECT e FROM Estudiante e WHERE libreta = ?1", Estudiante.class);
		query.setParameter(1,e.getLibreta());
		List<Estudiante> resultados = query.getResultList();
		@SuppressWarnings("unused")
		Estudiante existeEstudiante = null;
		if (!resultados.isEmpty()) {
			return existeEstudiante = (Estudiante) resultados.get(0);
		}
		em.persist(e);
		this.em.getTransaction().commit();
		return e;		
	}

	public Estudiante getEstudiante (int libreta) {
		Estudiante e = em.find(Estudiante.class,libreta);
		return e;
	}

	public List<Estudiante> getEstudiantes() {	
		TypedQuery<Estudiante> query = em.createQuery("SELECT e FROM Estudiante e ORDER BY apellido ASC", Estudiante.class);
		List<Estudiante> estudiantes = query.getResultList();
		return estudiantes;
	}


	public List<Estudiante> getEstudiantesGenero(String genero) {
		TypedQuery<Estudiante> query = em.createQuery("SELECT e FROM Estudiante e WHERE genero = ?1", Estudiante.class);
		query.setParameter(1, genero);
		List<Estudiante> estudiantes = query.getResultList();
		return estudiantes;
	}

	public List<Estudiante> getEstudiantesCarrera(Carrera c, String ciudad) {
		TypedQuery<Estudiante> query = em.createQuery("SELECT e FROM Estudiante e JOIN Registro r on (e.libreta = r.estudiante) WHERE e.ciudad = ?1 AND r.carrera = ?2", Estudiante.class);
		query.setParameter(1,ciudad);
		query.setParameter(2,c);
		List<Estudiante> estudiantes = query.getResultList();
		return estudiantes;
	}

	public static EstudianteDaoImpl getInstance(EntityManager em) {
		if (estudianteDaoImpl == null) {
			estudianteDaoImpl = new EstudianteDaoImpl(em);
		}
			return estudianteDaoImpl;
		}
}
