package com.example.myapp.rest;

import com.example.myapp.entites.Monitor;
import com.example.myapp.service.MonitorManager;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("monitor")
public class MonitorRESTService {

    @EJB
    MonitorManager monitorManager;

    @Path("/add")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addMonitor(Monitor monitor) {
        monitorManager.addMonitor(monitor);
        return Response.ok("Monitor").build();
    }

    @Path("/{monitorId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Monitor getMonitor(@PathParam("monitorId") Integer id) {
        return monitorManager.getMonitor(id);
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
    public List<Monitor> getAllMonitors() {
        return monitorManager.getAllMonitors();
    }
}
