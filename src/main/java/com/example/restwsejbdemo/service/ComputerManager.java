package com.example.restwsejbdemo.service;

import com.example.restwsejbdemo.entities.Computer;

import com.example.restwsejbdemo.entities.Computer_;
import com.example.restwsejbdemo.entities.Producer;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Stateless
public class ComputerManager {

    @PersistenceContext
    EntityManager entityManager;

    public void addComputer(Computer computer) {
        entityManager.persist(computer);
    }

    public void deleteComputer(Computer computer) {
        entityManager.remove(computer);
    }

    public Computer getComputer(Long id) {
        return entityManager.find(Computer.class, id);
    }

    public Computer updateComputer(Computer computer) {
        return entityManager.merge(computer);
    }

    @SuppressWarnings("unchecked")
    public List<Computer> getAllComputers() {
        return entityManager.createNamedQuery("computers").getResultList();
    }

    @SuppressWarnings("unchecked")
    public List<Object[]> getComputerByOwnerCity(String city) {
        return entityManager.createNamedQuery("computerOwner.findByOwnerByCity").setParameter("city", city).getResultList();
    }

    @SuppressWarnings("unchecked")
    public void deleteAll() {
        entityManager.createNamedQuery("computers.clear").executeUpdate();
    }

    public List<Computer> getComputersUnderPrice(Double price) {

        CriteriaBuilder qb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Computer> c = qb.createQuery(Computer.class);

        Root<Computer> b = c.from(Computer.class);

        Predicate condition = qb.le(b.get(Computer_.price), price);
        c.where(condition);

        TypedQuery<Computer> q = entityManager.createQuery(c);

        List<Computer> result = q.getResultList();

        return result;
    }

    public Producer getProducer(Long id) {
        return entityManager.find(Producer.class, id);
    }

}
