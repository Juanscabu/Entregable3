package daos;

import java.util.List;

import entities.Carrera;

public interface CarreraDao {
		public Carrera addCarrera(Carrera c);
		public Carrera getCarrera(int id);
		public List<Carrera> getCarrerasCantInscriptos();
		public List<Carrera> getReporteCarreras();	
		
}
