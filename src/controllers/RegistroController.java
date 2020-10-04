package controllers;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import daos.*;
import entities.Carrera;
import entities.Estudiante;
import entities.Registro;
import factory.JpaDaoFactory;

@Path("/registro")
public class RegistroController {
	private JpaDaoFactory jpaDaoFactory;
	private RegistroDao registroDao;
	private CarreraDao carreraDao;
	private EstudianteDao estudianteDao;
	
	@SuppressWarnings("static-access")
	public RegistroController() {
		this.jpaDaoFactory = JpaDaoFactory.getInstance();
		this.registroDao = jpaDaoFactory.getRegistroDao();
		this.carreraDao = jpaDaoFactory.getCarreraDao();
		this.estudianteDao = jpaDaoFactory.getEstudianteDao();
		
	}
	
	@POST
	@Path("/{libreta}/{cId}/{anio}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response matricularEstudiante(@PathParam("libreta")int libreta,@PathParam("cId")int cId, @PathParam("anio") int a) {
	Carrera c = this.carreraDao.getCarrera(cId);
	Estudiante e = this.estudianteDao.getEstudiante(libreta);
	Registro r1 = this.registroDao.matricularEstudiante(e, c, a);
	return Response.status(201).entity(r1).build();
	}
}
