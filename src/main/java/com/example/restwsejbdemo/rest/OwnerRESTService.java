package com.example.restwsejbdemo.rest;


import com.example.restwsejbdemo.entities.Owner;
import com.example.restwsejbdemo.service.OwnerManager;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("owner")
@Stateless
public class OwnerRESTService {

    @EJB
    private OwnerManager ownerManager;

    @GET
    @Path("/{computerId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Owner getPerson(@PathParam("computerId") Long id) {
        Owner owner = ownerManager.getOwner(id);
        return owner;
    }

    @POST
    @Path("add")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addOwner(Owner owner) {
        ownerManager.addOwner(owner);
        return Response.status(201).entity("Person").build();
    }

    @DELETE
    @Path("/remove/{id}")
    public void deletePerson(@PathParam("id") Long id) {
        ownerManager.deleteOwner(ownerManager.getOwner(id));
    }

    @DELETE
    public Response deleteAllOwners() {
        ownerManager.clearOwners();
        return Response.status(200).build();
    }

}
