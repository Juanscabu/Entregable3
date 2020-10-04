package sistema;

import javax.persistence.EntityManager;

import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import daosImpl.CarreraDaoImpl;
import entities.Carrera;
import entities.Estudiante;

public class Sistema {

	public static void main(String[] args) {
		//EntityManagerFactory emf = EMF.contextInitialized(null);
		//EntityManager em = EMF.createEntityManager();
		//EntityManager em = emf.createEntityManager();
		//em.getTransaction().begin();
		
		//EstudianteController e1 = new EstudianteController();
		//CarreraController c1 = new CarreraController(em);
		//RegistroController r1 = new RegistroController(em);
		
		//em.getTransaction().commit();
		
		//em.close();
		//emf.close();
	}

	private static void cargarCarreras(CSVParser carreras) {
		//el em de carrera
		//el get instance de carreraDao
		for(CSVRecord row: carreras) {
			String nombre = row.get("nombre");
			Carrera carrera = new Carrera(nombre);
			//c.addCarrera(carrera); DESCOMENTAR ESTO
			}
	}

	private static void cargarEstudiantes(CSVParser estudiantes) {
		//el em de estudiante
		//el get instance de estudianteDao
		for(CSVRecord row: estudiantes) {
			String nombre = row.get("nombre");
			String apellido = row.get("apellido");
			int edad =  Integer.parseInt(row.get("edad"));
			String genero = row.get("genero");
			int documento = Integer.parseInt(row.get("documento"));
			String ciudad = row.get("ciudad");
			int libreta = Integer.parseInt( row.get("libreta"));
			Estudiante estudiante = new Estudiante(nombre,apellido,edad,genero,documento,ciudad,libreta);
			//e.addEstudiante(estudiante); DESCOMENTAR ESTO
			}
	}
}
