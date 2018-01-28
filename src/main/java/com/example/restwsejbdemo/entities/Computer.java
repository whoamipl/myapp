package com.example.restwsejbdemo.entities;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
@Entity
@NamedQueries({
        @NamedQuery(name = "computers", query = "Select computer from Computer computer"),
        @NamedQuery(name = "computers.clear", query = "Delete from Computer "),
        @NamedQuery(name = "computerOwner.findByOwnerByCity", query = "Select o.firstName, o.lastName, c.model from Computer c JOIN c.owner o where o.city = :city")
})
public class Computer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String model;
    private String cpu;
    private String gpu;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Owner> owners = new ArrayList<>();
    private double price;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Producer producer;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Warranty warranty;


    public Computer() {
    }

    public Computer(String model, String cpu, String gpu, double price) {
        this.model = model;
        this.cpu = cpu;
        this.gpu = gpu;
        this.price = price;
    }

    public Computer(String model, String cpu, String gpu, double price, List<Owner> owners, Producer producer, Warranty warranty) {
        this.model = model;
        this.cpu = cpu;
        this.gpu = gpu;
        this.price = price;
        this.owners = owners;
        this.producer = producer;
        this.warranty = warranty;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getGpu() {
        return gpu;
    }

    public void setGpu(String gpu) {
        this.gpu = gpu;
    }

    public List<Owner> getOwners() {
        return owners;
    }

    public void setOwners(List<Owner> owners) {
        this.owners = owners;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    public Warranty getWarranty() {
        return warranty;
    }

    public void setWarranty(Warranty warranty) {
        this.warranty = warranty;
    }

    public void setOwnersList(List<Owner> owners) {

        this.setOwners(owners);
        for (Owner o : owners) {
            o.getComputers().add(this);
        }
    }
}
