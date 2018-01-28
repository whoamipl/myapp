package com.example.restwsejbdemo.service;

import com.example.restwsejbdemo.entities.Owner;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class OwnerManager {

    @PersistenceContext
    EntityManager entityManager;

    public void addOwner(Owner owner) {
        entityManager.persist(owner);
    }

    public void deleteOwner(Owner owner) {
        entityManager.remove(owner);
    }

    public Owner getOwner(Long id) {
        return entityManager.find(Owner.class, id);
    }

    public Owner updateOwner(Owner owner) {
        return entityManager.merge(owner);
    }

    public void clearOwners() {
        entityManager.createNamedQuery("owner.clear").executeUpdate();
    }
}
