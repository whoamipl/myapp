package com.example.restwsdemo.domain;

import com.example.restwsdemo.entites.Monitor;
import com.example.restwsdemo.entites.Owner;
import com.example.restwsdemo.entites.Producent;
import com.example.restwsdemo.entites.Warranty;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
@Entity
public class Computer  {

    private Long id;
    private String model;
    private int ram;
    private String cpu;
    private int hdd;

    private String gpu;
    private double price;
    private int amout;
    private List<Owner> owner;
    private Warranty warranty;
    @ManyToOne
    private Producent producent;

    @OneToMany
    private List<Monitor> monitors;

    public void setMonitors(List<Monitor> monitors) {
        this.monitors = monitors;
    }

    public Producent getProducent() {
        return producent;
    }

    public void setProducent(Producent producent) {
        this.producent = producent;
    }

    @OneToMany
    public List<Monitor> getMonitors() {
        return monitors;
    }

    @ManyToMany
    public List<Owner> getOwner() {
        return owner;
    }

    public void setOwner(List<Owner> owner) {
        this.owner = owner;
    }

    @OneToOne
    public Warranty getWarranty() {
        return warranty;
    }

    public void setWarranty(Warranty warranty) {
        this.warranty = warranty;
    }

    public Computer () {

    }


    public Computer(String model, int ram, String cpu, int hdd, String gpu, double price,
                    int amout, String producentName, ArrayList<Monitor> monitors, List<Owner> owners) {
        this.model = model;
        this.ram = ram;
        this.cpu = cpu;
        this.hdd = hdd;
        this.gpu = gpu;
        this.price = price;
        this.amout = amout;
        this.producent = new Producent(producentName);
        this.monitors = monitors;
        this.owner = owners;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
