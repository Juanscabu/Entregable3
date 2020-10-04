package factory;

import javax.persistence.EntityManager;

import daos.CarreraDao;
import daos.EstudianteDao;
import daos.RegistroDao;
import daosImpl.*;

public class JpaDaoFactory implements DAOFactory{
	
	private static JpaDaoFactory jpaDaoFactory;
	private static CarreraDao carreraDao;
	private static EstudianteDao estudianteDao;
	private static RegistroDao registroDao;
	private EntityManager em;
	
	private JpaDaoFactory() {
		jpaDaoFactory = null;
		carreraDao = null;
		estudianteDao = null;
		registroDao = null;
		this.em = EMF.createEntityManager();
	}
	
	public static JpaDaoFactory getInstance() {
		if (jpaDaoFactory == null) {
			jpaDaoFactory = new JpaDaoFactory();
			return jpaDaoFactory;
		} else {
			return jpaDaoFactory;
		}
	}

	@Override
	public CarreraDao getCarreraDao() {
		if (carreraDao == null) {
			carreraDao = CarreraDaoImpl.getInstance(this.em);
			return carreraDao;
		} else {
			return carreraDao;
		}
	}

	@Override
	public EstudianteDao getEstudianteDao() {
		if (estudianteDao == null) {
			estudianteDao = EstudianteDaoImpl.getInstance(this.em);
			return estudianteDao;
		} else {
			return estudianteDao;
		}
	}

	@Override
	public RegistroDao getRegistroDao() {
		if (registroDao == null) {
			registroDao = RegistroDaoImpl.getInstance(this.em);
			return registroDao;
		} else {
			return registroDao;
		}
	}
	
}
