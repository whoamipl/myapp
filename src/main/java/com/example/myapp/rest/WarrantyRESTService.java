package com.example.myapp.rest;

import com.example.myapp.entites.Warranty;
import com.example.myapp.service.WarrantyManager;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("warranty")
public class WarrantyRESTService {
    @EJB
    WarrantyManager warrantyManager;

    @Path("/add")
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public Response addWarranty() {
        warrantyManager.addWarranty(new Warranty());
        return Response.status(201).build();
    }
}
