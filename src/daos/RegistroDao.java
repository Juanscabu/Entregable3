package daos;

import javax.persistence.EntityManager;

import daosImpl.RegistroDaoImpl;
import entities.Carrera;
import entities.Estudiante;

public interface RegistroDao {

	public boolean matricularEstudiante(Estudiante e,Carrera c, int a);
	public RegistroDaoImpl getInstance(EntityManager em);
}
