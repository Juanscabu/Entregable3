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

import daos.*;
import entities.Carrera;
import entities.Estudiante;
import factory.JpaDaoFactory;

@Path("/estudiante")
public class EstudianteController {
	private JpaDaoFactory jpaDaoFactory;
	private EstudianteDao estudianteDao;

	@SuppressWarnings("static-access")
	public EstudianteController() {
		this.jpaDaoFactory = JpaDaoFactory.getInstance();
		this.estudianteDao = jpaDaoFactory.getEstudianteDao();
	}
	 
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addEstudiante(Estudiante e) {
		Estudiante estudiante = this.estudianteDao.addEstudiante(e);
		return Response.status(201).entity(estudiante).build();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Estudiante getEstudiante( @PathParam("id") int libreta) {
		Estudiante estudiante = this.estudianteDao.getEstudiante(libreta);
		return estudiante;
	}
	
	@GET
	@Path("/estudiantes")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Estudiante> getEstudiantes() {
		List<Estudiante> e1 = this.estudianteDao.getEstudiantes();
		return e1;
	}
	
	@GET
	@Path("/estudiantesGenero/{genero}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Estudiante> getEstudianteGenero(@PathParam("genero") String genero) {
		List<Estudiante> estudiantes = this.estudianteDao.getEstudiantesGenero(genero);
		return estudiantes;
	}
	
	@GET
	@Path("/estudiantesCarrera/{carrera}/{ciudad}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Estudiante> getEstudiantesCarrera(@PathParam("carrera") Carrera c, @PathParam("ciudad") String ciudad){
		List<Estudiante> estudiantes = this.estudianteDao.getEstudiantesCarrera(c, ciudad);
		return estudiantes;
	}
}
