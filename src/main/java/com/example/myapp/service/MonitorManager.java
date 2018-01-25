package com.example.myapp.service;
import com.example.myapp.entites.Monitor;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Stateless
public class MonitorManager {
    
    private List<Monitor> storage = Collections.synchronizedList(new ArrayList<Monitor>());

    @PersistenceContext
    EntityManager em;

    public MonitorManager() {
        storage.add(new Monitor("Benqu", 27.5));
    }

    public Monitor getMonitor(Integer id) {
        Monitor monitor = storage.get(id);
        if (monitor == null) return new Monitor();
        return monitor;
    }

    public List<Monitor> getAllMonitors() {
        return storage;
    }

    public void addMonitor(Monitor Monitor) {
        em.persist(Monitor);
    }

    public List<Monitor> getAllMonitor() {
        return  storage;
    }

    public java.lang.String test() {return "REST Service is running";}

    public void removeMonitor(Long id) {
        em.remove(new MonitorManager().getMonitor(id.intValue()));
    }

}
