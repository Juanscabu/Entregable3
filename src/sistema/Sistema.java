package sistema;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import daos.CarreraDao;
import daos.EstudianteDao;
import entities.Carrera;
import entities.Estudiante;
import factory.JpaDaoFactory;


public class Sistema {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		JpaDaoFactory jpaDaoFactory = JpaDaoFactory.getInstance();
		EstudianteDao estudianteDao = jpaDaoFactory.getEstudianteDao();
		CarreraDao carreraDao = jpaDaoFactory.getCarreraDao();
		CSVParser estudiantes = CSVFormat.DEFAULT.withHeader().parse(new FileReader("./csv/estudiantes.csv"));
		CSVParser carreras = CSVFormat.DEFAULT.withHeader().parse(new FileReader("./csv/carreras.csv"));
		
		cargarEstudiantes(estudiantes,estudianteDao);
		cargarCarreras(carreras,carreraDao);
	}

	private static void cargarCarreras(CSVParser carreras,CarreraDao carreraDao) {
		for(CSVRecord row: carreras) {
			String nombre = row.get("nombre");
			Carrera carrera = new Carrera(nombre);
			carreraDao.addCarrera(carrera);
			}
	}

	private static void cargarEstudiantes(CSVParser estudiantes,EstudianteDao estudianteDao) {
		for(CSVRecord row: estudiantes) {
			String nombre = row.get("nombre");
			String apellido = row.get("apellido");
			int edad =  Integer.parseInt(row.get("edad"));
			String genero = row.get("genero");
			int documento = Integer.parseInt(row.get("documento"));
			String ciudad = row.get("ciudad");
			int libreta = Integer.parseInt( row.get("libreta"));
			Estudiante estudiante = new Estudiante(nombre,apellido,edad,genero,documento,ciudad,libreta);
			estudianteDao.addEstudiante(estudiante);
			}
	}
}
