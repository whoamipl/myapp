package com.example.myapp.rest;

import com.example.myapp.domain.Computer;
import com.example.myapp.service.ComputerManager;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
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
@Stateless
public class ComputerRESTService {

	@Inject
	private ComputerManager pm;

	@GET
	@Path("/{computerId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Computer getPerson(@PathParam("computerId") Integer id) {
		Computer p = pm.getComputer(id);
		return p;
	}


	@Produces(MediaType.APPLICATION_JSON)
	public List<Computer> getComputer() {
		return pm.getAllComputer();
	}

	@POST
	@Path("addComputer")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addComputer(Computer computer) {
		pm.addComputer(computer);
		return Response.status(201).entity("Successful added computer. You're awesome!").build();
	}

	@DELETE
	@Path("removeComputer/{id}")
	public void deleteComputer(@PathParam("id") Long id) {
		pm.removeComputer(idFGIT);
	}

	//http://localhost:8080/restwsejbdemo/api/computer/addComputer@GET
	@Path("test")
	@Produces(MediaType.TEXT_PLAIN)
	public String test() {
		return "REST API /person is running today!";
	}

	@DELETE
	public Response clearComputer() {
		return Response.status(200).build();
	}

}
