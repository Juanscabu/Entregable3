package daos;

import java.util.List;

import javax.persistence.EntityManager;

import daosImpl.EstudianteDaoImpl;
import entities.Carrera;
import entities.Estudiante;

public interface EstudianteDao {
		public Estudiante addEstudiante(Estudiante e);
		public Estudiante getEstudiante(int libreta);
		public List<Estudiante> getEstudiantes();
		public List<Estudiante> getEstudiantesGenero(String genero);
		public List<Estudiante> getEstudiantesCarrera(Carrera c, String ciudad);
		public EstudianteDaoImpl getInstance(EntityManager em);
}
