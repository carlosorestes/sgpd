package com.sgpd.br.response;

import java.util.List;

import com.sgpd.br.entities.Person;

public class PersonResponse {
	
	private List<Person> persons;
	private int totalPages;
	private int pageNumber;
	private int pageSize;

	public PersonResponse() {}
	
	public PersonResponse(List<Person> persons, int totalPages, int pageNumber, int pageSize) {
		this.persons = persons;
		this.totalPages = totalPages;
		this.pageNumber = pageNumber;
		this.pageSize = pageSize;
	}
	
	public Person builder(Long id, String nome, String  cpf, String  telefone1, String  telefone2) {
		return new Person(id, nome, cpf, telefone1, telefone2);
	}
	
	public List<Person> getPersons() {
		return persons;
	}
	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
}
