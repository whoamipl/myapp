package com.example.restwsejbdemo.rest;


import com.example.restwsejbdemo.entities.Producer;
import com.example.restwsejbdemo.service.ProducerManager;
import com.google.gson.Gson;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.StringReader;

@Path("producer")
@Stateless
public class ProducerRESTService {

    @Inject
    private ProducerManager producerManager;

    @GET
    @Path("/{producerId}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getProducer(@PathParam("producerId") Long id) {
        Producer c = producerManager.getProducer(id);
        Gson gson = new Gson();
        return gson.toJson(c);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addProducer(Producer producer) {
        System.out.println("!!!!!!!!!!!!" + producer);
        producerManager.addProducer(producer);
        return Response.status(201).entity("Producer").build();
    }

    @DELETE
    @Path("/remove/{id}")
    public void deleteBook(@PathParam("id") Long id) {
        producerManager.deleteProducer(producerManager.getProducer(id));
    }

    @POST
    @Path("/json")
    public Response addProducerWithJsonReader(String producer) {

        JsonObject jsonObject = Json.createReader(new StringReader(producer)).readObject();

        Producer plainProducer = new Producer();
        plainProducer.setName(jsonObject.getString("name"));

        producerManager.addProducer(plainProducer);
        return Response.status(201).entity("Producer").build();
    }

}
