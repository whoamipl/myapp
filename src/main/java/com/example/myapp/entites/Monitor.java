package com.example.myapp.entites;

import javax.persistence.*;

@Entity
public class Monitor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @ManyToOne
    private Computer computer;

    public Monitor() {
    }

    public Monitor(String name, double diagonal) {
        this.name = name;
        this.diagonal = diagonal;
    }

    private double diagonal;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDiagonal() {
        return diagonal;
    }

    public void setDiagonal(double diagonal) {
        this.diagonal = diagonal;
    }
}
