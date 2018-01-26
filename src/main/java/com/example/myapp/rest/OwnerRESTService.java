package com.example.myapp.rest;

import com.example.myapp.entites.Owner;
import com.example.myapp.service.OwnerManager;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("owner")
public class OwnerRESTService {

        @EJB
        OwnerManager ownerManager;

        @Path("/add")
        @POST
        @Consumes(MediaType.APPLICATION_JSON)
        public Response addOwner(Owner owner) {
            ownerManager.addOwner(owner);
            return Response.ok("owner").build();
        }

        @Path("/{ownerId}")
        @GET
        @Produces(MediaType.APPLICATION_JSON)
        public Owner getowner(@PathParam("ownerId") Integer id) {
            return ownerManager.getOwner(id);
        }

        @Path("/test")
        @GET
        @Produces(MediaType.TEXT_PLAIN)
        public String test() {
            return "Everithing woriks";
        }

        @Path("/all")
        @GET
        @Produces(MediaType.APPLICATION_JSON)
        public List<Owner> getAllowners() {
            return ownerManager.getAllOwners();
        }
    }
