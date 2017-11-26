package com.example.restwsdemo.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ComputerResponse {
	

	private List<Computer> person;

	public List<Computer> getPerson() {
		return person;
	}

	public void setPerson(List<Computer> person) {
		this.person = person;
	}

}
