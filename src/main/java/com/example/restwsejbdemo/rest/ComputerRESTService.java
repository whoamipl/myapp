package com.example.restwsejbdemo.rest;

import com.example.restwsejbdemo.entities.Computer;
import com.example.restwsejbdemo.entities.Producer;
import com.example.restwsejbdemo.entities.Owner;
import com.example.restwsejbdemo.entities.Warranty;
import com.example.restwsejbdemo.service.ComputerManager;

import javax.ejb.EJB;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Path("computer")
public class ComputerRESTService {


    @EJB
    private ComputerManager computerManager;

    @GET
    @Path("/{id}")
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    public Computer getComputer(@PathParam("id") Long id) {

        Computer computer = computerManager.getComputer(id);
        return computer;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response addComputer(Computer computer) {

        computerManager.addComputer(computer);
        return Response.status(201).entity("Computer").build();
    }

    @DELETE
    @Path("/remove/{id}")
    @Transactional
    public void deleteBook(@PathParam("id") Long id) {
        computerManager.deleteComputer(computerManager.getComputer(id));

    }

    @DELETE
    @Transactional
    public Response clearBooks() {
        computerManager.deleteAll();
        return Response.status(200).build();
    }

    @GET
    @Path("bycity/{city}")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response getOwnerByCity(@PathParam("city") String city) {

        List<Object[]> fromReq = computerManager.getComputerByOwnerCity(city);
        JsonArrayBuilder owners = Json.createArrayBuilder();

        for (Object[] owner : fromReq) {
            String name = (String) owner[0];
            String surname = (String) owner[1];
            String model = (String) owner[2];
            owners
                    .add(Json.createObjectBuilder()
                    .add("firstName", surname)
                    .add("lastName", name)
                    .add("model", model));
        }
        return Response.ok(Json.createObjectBuilder().add("Owners-By-City", owners).build(),
                MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Path("/price/{price}")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public List<Computer> getBooksByPrice(@PathParam("price") Double price) {

        List<Computer> computers = computerManager.getComputersUnderPrice(price);
        return computers;
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Transactional
    public String testManyToManyRelation() {

        Owner owner1 = new Owner("Jan", "Kowalski", "Warszawa");
        Owner owner2 = new Owner("Kamil", "Nowak", "Sosnowiec");
        Computer computer1 = new Computer("KabbyX", "Ryzen7","GTX1080Ti", 2229.99);
        Computer computer2 = new Computer("XPS223", "IntelC2D", "GT1030", 1500.99);

        computerManager.addComputer(computer1);

        List<Owner> owners = new ArrayList<>();
        owners.add(owner1);
        owners.add(owner2);

        computer1.setOwnersList(owners);
        computerManager.updateComputer(computer1);

        return "Relation ManyToMany works";
    }

    @GET
    @Path("/lazyexptest")
    @Produces(MediaType.TEXT_PLAIN)
    public String lazyInitializationExp() {

        Owner owner1 = new Owner("Jan", "Kowalski", "Warszawa");
        Owner owner2 = new Owner("Kamil", "Nowak", "Sosnowiec");

        List<Owner> owners= new ArrayList<>();
        owners.add(owner1);
        owners.add(owner2);

        Producer producer = new Producer("COMPANY_NAME");
        Calendar dueDate = Calendar.getInstance();
        dueDate.add(Calendar.YEAR, 2);
        Warranty warranty = new Warranty(dueDate);
        Computer computer = new Computer("Kabby","Ryzen3", "GTX1050",2000.99,owners,producer, warranty);
        computerManager.addComputer(computer);

        Computer alreadyAdded = computerManager.getComputer(1l);
        try {
            System.out.println(alreadyAdded.getProducer().getName());
        } catch (Exception e) {
            e.printStackTrace();
            return "LazyInitializationException";
        }
        return "No problem";
    }

}
