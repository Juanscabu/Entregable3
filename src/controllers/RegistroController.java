package controllers;

import javax.persistence.EntityManager;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import daosImpl.RegistroDaoImpl;
import entities.Carrera;
import entities.Estudiante;

@Path("/registro")
public class RegistroController {
	private EntityManager em;
	
	public RegistroController(EntityManager em) {
		this.em = em;
	}
	
	/*@POST
	@Path("/{estudiante}/{carrera}/{anio}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response matricularEstudiante(@PathParam("estudiante") Estudiante e,@PathParam("carrera") Carrera c,@PathParam("anio") int a) {
	RegistroDaoImpl r1 = new RegistroDaoImpl(em);
	boolean r2 = r1.matricularEstudiante(e, c, a);
	return Response.status(201).entity(r2).build();
	}*/
}
