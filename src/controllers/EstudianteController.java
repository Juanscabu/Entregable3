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
		//EntityManagerFactory emf = Persistence.createEntityManagerFactory("Example");
		//this.em = emf.createEntityManager();
		//recibir el dao
		this.jpaDaoFactory = JpaDaoFactory.getInstance();
		this.estudianteDao = jpaDaoFactory.getEstudianteDao();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addEstudiante(Estudiante e) {
		//em.getTransaction().begin();
		//EstudianteDaoImpl e1 = new EstudianteDaoImpl(em);
		Estudiante e2 = this.estudianteDao.addEstudiante(e);
		//this.em.getTransaction().commit();
		//em.close();
		return Response.status(201).entity(e2).build();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Estudiante getEstudiante( @PathParam("id") int libreta) {
		//EstudianteDaoImpl e = new EstudianteDaoImpl(em);
		Estudiante e1 = this.estudianteDao.getEstudiante(libreta);
		return e1;
	}
	
	@GET
	@Path("/estudiantes")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Estudiante> getEstudiantes() {
		//EstudianteDaoImpl e = new EstudianteDaoImpl(em);
		List<Estudiante> e1 = this.estudianteDao.getEstudiantes();
		return e1;
	}
	
	@GET
	@Path("/estudiantesGenero/{genero}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Estudiante> getEstudianteGenero(@PathParam("genero") String genero) {
		//EstudianteDaoImpl e = new EstudianteDaoImpl(em);
		List<Estudiante> e1 = this.estudianteDao.getEstudiantesGenero(genero);
		return e1;
	}
	
	@GET
	@Path("/estudiantesCarrera/{carrera}/{ciudad}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Estudiante> getEstudiantesCarrera(@PathParam("carrera") Carrera c, @PathParam("ciudad") String ciudad){
		//EstudianteDaoImpl e = new EstudianteDaoImpl(em);
		List<Estudiante> e1 = this.estudianteDao.getEstudiantesCarrera(c, ciudad);
		return e1;
	}
}
