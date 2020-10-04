package controllers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import daosImpl.CarreraDaoImpl;
import entities.Carrera;

@Path("/carrera")
public class CarreraController {
	private EntityManager em;

	public CarreraController(EntityManager em) {
		this.em = em;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addCarrera (Carrera c) {
		CarreraDaoImpl c1 = new CarreraDaoImpl(em);
		Carrera c2 = c1.addCarrera(c);
		return Response.status(201).entity(c2).build();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Carrera getCarrera (@PathParam("id") int id) {
		CarreraDaoImpl c1 = new CarreraDaoImpl(em);
		Carrera c2 = c1.getCarrera(id);
		return c2;
	}
	
	@GET
	@Path("/carreraInscriptos")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Carrera> getCarrerasCantInscriptos() {
		CarreraDaoImpl c1 = new CarreraDaoImpl(em);
		List<Carrera> c2 = c1.getCarrerasCantInscriptos();
		return c2;
	}
	
	@GET
	@Path("/carreraReporte")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Carrera> getReporteCarreras() {
		CarreraDaoImpl c1 = new CarreraDaoImpl(em);
		List<Carrera> c2 = c1.getReporteCarreras();
		return c2;
	}
}
