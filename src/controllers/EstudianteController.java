package controllers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import daosImpl.EstudianteDaoImpl;
import entities.Carrera;
import entities.Estudiante;

@Path("/estudiante")
public class EstudianteController {
	private EntityManager em;

	public EstudianteController(/*EntityManager em*/) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Example");
		this.em = emf.createEntityManager();
		//this.em = em;
		//recibir el dao
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addEstudiante(Estudiante e) {
		EstudianteDaoImpl e1 = new EstudianteDaoImpl(em);
		Estudiante e2 = e1.addEstudiante(e);
		return Response.status(201).entity(e2).build();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Estudiante getEstudiante( @PathParam("id") int libreta) {
		EstudianteDaoImpl e = new EstudianteDaoImpl(em);
		Estudiante e1 = e.getEstudiante(libreta);
		return e1;
	}
	
	@GET
	@Path("/estudiantes")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Estudiante> getEstudiantes() {
		EstudianteDaoImpl e = new EstudianteDaoImpl(em);
		List<Estudiante> e1 = e.getEstudiantes();
		return e1;
	}
	
	@GET
	@Path("/estudiantesGenero/{genero}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Estudiante> getEstudianteGenero(@PathParam("genero") String genero) {
		EstudianteDaoImpl e = new EstudianteDaoImpl(em);
		List<Estudiante> e1 = e.getEstudiantesGenero(genero);
		return e1;
	}
	
	@GET
	@Path("/estudiantesCarrera/{carrera}/{ciudad}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Estudiante> getEstudiantesCarrera(@PathParam("carrera") Carrera c, @PathParam("ciudad") String ciudad){
		EstudianteDaoImpl e = new EstudianteDaoImpl(em);
		List<Estudiante> e1 = e.getEstudiantesCarrera(c, ciudad);
		return e1;
	}
}
