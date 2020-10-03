package daos;

import java.util.List;

import entities.Estudiante;

public interface EstudianteDao {
		public Estudiante addEstudiante(Estudiante e);
		public Estudiante getEstudiante(int libreta);
		public List<Estudiante> getEstudiantes();
		public List<Estudiante> getEstudiantesGenero(String genero);
}
