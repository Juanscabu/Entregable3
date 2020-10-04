package factory;

import javax.persistence.EntityManager;

import daos.CarreraDao;
import daos.EstudianteDao;
import daos.RegistroDao;

public class JpaDaoFactory implements DAOFactory{
	
	private static JpaDaoFactory JpaDaoFactory;
	private static CarreraDao CarreraDao;
	private static EstudianteDao EstudianteDao;
	private static RegistroDao RegistroDao;
	private EntityManager em;
	
	public JpaDaoFactory() {
		JpaDaoFactory = null;
		CarreraDao = null;
		EstudianteDao = null;
		RegistroDao = null;
		this.em = EMF.createEntityManager();
	}
	
	public static JpaDaoFactory getInstance() {
		if (JpaDaoFactory == null) {
			JpaDaoFactory = new JpaDaoFactory();
			return JpaDaoFactory;
		} else {
			return JpaDaoFactory;
		}
	}

	@Override
	public CarreraDao getCarreraDao() {
		if (CarreraDao == null) {
			CarreraDao = this.CarreraDao.getInstance(this.em);
			return CarreraDao;
		} else {
			return CarreraDao;
		}
	}

	@Override
	public EstudianteDao getEstudianteDao() {
		if (EstudianteDao == null) {
			EstudianteDao = this.EstudianteDao.getInstance(this.em);
			return EstudianteDao;
		} else {
			return EstudianteDao;
		}
	}

	@Override
	public RegistroDao getRegistroDao() {
		if (RegistroDao == null) {
			RegistroDao = this.getRegistroDao().getInstance(this.em);
			return RegistroDao;
		} else {
			return RegistroDao;
		}
	}
	
}
