package factory;

import daos.CarreraDao;
import daos.EstudianteDao;
import daos.RegistroDao;

public interface DAOFactory {

	public CarreraDao getCarreraDao();
	public EstudianteDao getEstudianteDao();
	public RegistroDao getRegistroDao();
	
}
