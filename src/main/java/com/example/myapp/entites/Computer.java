package com.example.myapp.entites;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Calendar;
import java.util.List;

@XmlRootElement
@Entity
public class Computer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String model;
    private int ram;
    private String cpu;
    private int hdd;

    private String gpu;
    private double price;
    private int amout;
    @OneToOne
    private Warranty warranty;
    @ManyToOne
    private Owner owner;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "computer", fetch = FetchType.LAZY)
    private List<Monitor> monitors;

    public void setMonitors(List<Monitor> monitors) {
        this.monitors = monitors;
    }

    public List<Monitor> getMonitors() {
        return monitors;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Warranty getWarranty() {
        return warranty;
    }

    public void setWarranty(Warranty warranty) {
        this.warranty = warranty;
    }

    public Computer() {

    }

    public Computer(String model, int ram, String cpu, int hdd, String gpu, double price,
                    int amout) {
        this.model = model;
        this.ram = ram;
        this.cpu = cpu;
        this.hdd = hdd;
        this.gpu = gpu;
        this.price = price;
        this.amout = amout;
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

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public int getHdd() {
        return hdd;
    }

    public void setHdd(int hdd) {
        this.hdd = hdd;
    }

    public String getGpu() {
        return gpu;
    }

    public void setGpu(String gpu) {
        this.gpu = gpu;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmout() {
        return amout;
    }

    public void setAmout(int amout) {
        this.amout = amout;
    }
}
