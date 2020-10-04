package controllers;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import daos.*;
import factory.JpaDaoFactory;

@Path("/registro")
public class RegistroController {
	private JpaDaoFactory JpaDaoFactory;
	private RegistroDao RegistroDao;
	
	@SuppressWarnings("static-access")
	public RegistroController() {
		this.JpaDaoFactory.getInstance();
		this.RegistroDao = JpaDaoFactory.getRegistroDao();
	}
	
	/*@POST
	@Path("/{anio}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response matricularEstudiante(Estudiante e, Carrera c, @PathParam("anio") int a) {
	RegistroDaoImpl r1 = new RegistroDaoImpl(em);
	boolean r2 = r1.matricularEstudiante(e, c, a);
	return Response.status(201).entity(r2).build();
	}*/
}
