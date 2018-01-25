package com.example.myapp.service;


import com.example.myapp.entites.Owner;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Stateless
public class OwnerManager {
    private List<Owner> storage = Collections.synchronizedList(new ArrayList<Owner>());

    @PersistenceContext
    EntityManager em;

    public OwnerManager() {
        storage.add(new Owner("Michał"));
    }

    public Owner getOwner(Integer id) {
        Owner Owner = storage.get(id);
        if (Owner == null) return new Owner();
        return Owner;
    }

    public List<Owner> getAllOwners() {
        return storage;
    }

    public void addOwner(Owner Owner) {
        em.persist(Owner);
    }

    public List<Owner> getAllOwner() {
        return  storage;
    }

    public java.lang.String test() {return "REST Service is running";}

    public void removeOwner(Long id) {
        em.remove(new OwnerManager().getOwner(id.intValue()));
    }

}
