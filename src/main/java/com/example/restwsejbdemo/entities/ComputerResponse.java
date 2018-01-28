package com.example.restwsejbdemo.entities;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class ComputerResponse {

    private List<Computer> computers;

    public List<Computer> getComputer() {
        return computers;
    }

    public void setCemputer(List<Computer> book) {
        this.computers = book;
    }
}
