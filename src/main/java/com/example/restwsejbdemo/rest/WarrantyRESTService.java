package com.example.restwsejbdemo.rest;

import com.example.restwsejbdemo.entities.Warranty;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("warranty")
@Stateless
public class WarrantyRESTService {

    @PersistenceContext
    EntityManager entityManager;

    @GET
    @Path("/{producerId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Warranty getPlaceOnShelf(@PathParam("producerId") Long id) {
        return entityManager.find(Warranty.class, id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addPlaceOnShelf(Warranty placeOnShelf) {
        entityManager.persist(placeOnShelf);
        return Response.status(201).entity("Warranty").build();
    }

    @DELETE
    @Path("/remove/{id}")
    public void deleteBook(@PathParam("id") Long id) {
        Warranty pos = entityManager.find(Warranty.class, id);
        entityManager.remove(pos);

    }


}
