package com.example.myapp.domain;

import com.example.myapp.entites.Computer;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ComputerResponse {

	private List<Computer> computers;

	public List<Computer> getComputers() {
		return computers;
	}

	public void setComputers(List<Computer> computers) {
		this.computers = computers;
	}

}
