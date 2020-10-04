package daos;


import entities.Carrera;
import entities.Estudiante;
import entities.Registro;

public interface RegistroDao {

	public Registro matricularEstudiante(Estudiante e,Carrera c, int a);
	
}
