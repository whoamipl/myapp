package com.example.restwsdemo.entites;

import com.example.restwsdemo.domain.Computer;

import javax.persistence.*;

@Entity
public class Monitor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

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
}
