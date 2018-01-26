package com.example.myapp.service;

import com.example.myapp.entites.Warranty;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

@Stateless
public class WarrantyManager {

    private List<Warranty> storage = Collections.synchronizedList(new ArrayList<Warranty>());

    @PersistenceContext
    EntityManager em;

    public WarrantyManager() {
        Calendar today = Calendar.getInstance();
        today.add(Calendar.YEAR, 2);
        storage.add(new Warranty());
    }

    public Warranty getWarranty(Integer id) {
        Warranty Warranty = storage.get(id);
        if (Warranty == null) return new Warranty();
        return Warranty;
    }

    public List<Warranty> getAllWarrantys() {
        return storage;
    }

    public void addWarranty(Warranty Warranty) {
        em.persist(Warranty);
    }

    public List<Warranty> getAllWarranty() {
        return  storage;
    }

    public void removeWarranty(Long id) {
        em.remove(new WarrantyManager().getWarranty(id.intValue()));
    }

}
