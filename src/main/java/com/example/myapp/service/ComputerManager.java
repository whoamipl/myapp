package com.example.myapp.service;


import com.example.myapp.entites.Computer;
import com.example.myapp.entites.Monitor;
import com.example.myapp.entites.Owner;
import com.example.myapp.entites.Warranty;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Stateless
public class ComputerManager {

    private List<Computer> storage = Collections.synchronizedList(new ArrayList<Computer>());

    @PersistenceContext
    EntityManager em;

//    @Inject
//    MonitorManager monitorManager;
//    @Inject
//    OwnerManager ownerManagerm;
//    @Inject
//    WarrantyManager warrantyManager;

    public ComputerManager() {

    }

    public Computer getComputer(Integer id) {
        Computer computer = storage.get(id);
        if (computer == null) return new Computer();
        return computer;
    }

    public List<Computer> getAllComputers() {
        return storage;
    }

    public void addComputer(Computer computer) {
        em.persist(computer);
    }

    public List<Computer> getAllComputer() {
        return  storage;
    }

    public java.lang.String test() {return "REST Service is running";}

    public void removeComputer(Long id) {
        em.remove(new ComputerManager().getComputer(id.intValue()));
    }

    public void addAll() {

       em.persist(new Warranty());
       em.persist(new Monitor());
       em.persist(new Owner());
       em.persist(new Computer("Kabby", 16, "Ryzen 7", 1, "GTX 1080Ti", 2999,1));
    }

}
