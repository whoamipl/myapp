//TODO:
//1.@OneToMany(cascade = .. , fetch=)
//2.Lazy initialization <- umieć wskazać
//3. @EJB Path("..") class RestApi {
//						@EJB
//						Manager m ...
//                      @Post
//  					@Get itp.
package com.example.myapp.rest;

import com.example.myapp.entites.Computer;
import com.example.myapp.service.ComputerManager;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("computer")
public class ComputerRESTService {

	@EJB
	private ComputerManager computerManager;

	@Path("/{computerId}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Computer getComputer(@PathParam("computerId") Integer id) {
		Computer c = computerManager.getComputer(id);
		return c;
	}


	@Produces(MediaType.APPLICATION_JSON)
	public List<Computer> getComputer() {
		return computerManager.getAllComputer();
	}

	@Path("/add")
	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	public Response addComputer(Computer computer) {
		computerManager.addComputer(computer);
		return Response.status(201).entity("Computer was successfully added").build();
	}

	@Path("/remove/{id}")
	@DELETE
	public void deleteComputer(@PathParam("id") long id) {
		computerManager.removeComputer(id);
	}

	@Path("/test")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String test() {
		return "REST API computer is running today!";
	}

	@DELETE
	public Response clearComputer() {
		return Response.status(200).build();
	}


}
