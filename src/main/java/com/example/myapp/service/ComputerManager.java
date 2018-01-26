package com.example.myapp.service;


import com.example.myapp.entites.Computer;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Stateless
@Local
public class ComputerManager {

    private List<Computer> storage = Collections.synchronizedList(new ArrayList<Computer>());

    @PersistenceContext
    EntityManager em;

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

}
