package daos;

import entities.Carrera;
import entities.Estudiante;

public interface RegistroDao {

	public boolean matricularEstudiante(Estudiante e,Carrera c, int a);
}
