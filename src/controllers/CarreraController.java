package controllers;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import daos.CarreraDao;
import entities.Carrera;
import factory.*;

@Path("/carrera")
public class CarreraController {
	private JpaDaoFactory jpaDaoFactory;
	private CarreraDao carreraDao;
 
	@SuppressWarnings("static-access")
	public CarreraController() {
		this.jpaDaoFactory = JpaDaoFactory.getInstance();
		this.carreraDao = jpaDaoFactory.getCarreraDao();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addCarrera (Carrera c) {
		Carrera c2 = this.carreraDao.addCarrera(c);
		return Response.status(201).entity(c2).build();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Carrera getCarrera (@PathParam("id") int id) {
		Carrera carrera = this.carreraDao.getCarrera(id);
		return carrera;
	}
	
	@GET
	@Path("/Inscriptos")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Carrera> getCarrerasCantInscriptos() {
		List<Carrera> carreras = this.carreraDao.getCarrerasCantInscriptos();
		return carreras;
	}
	
	@GET
	@Path("/Reporte")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Carrera> getReporteCarreras() {
		List<Carrera> carreras = this.carreraDao.getReporteCarreras();
		return carreras;
	}
}
