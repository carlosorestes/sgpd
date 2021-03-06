package com.sgpd.br.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sgpd.br.entities.Person;
import com.sgpd.br.repositories.PersonRepository;

@Service
public class PersonService {
	
	@Autowired
	private PersonRepository personRepository;
	
	public Page<Person> findAllPageable(Pageable pageable){
		return personRepository.findAll(pageable);
	}
	
	public Iterable<Person> findAll(){
		return personRepository.findAll();
	}

	public Person findbyId(Long id) {
		Optional<Person> person = personRepository.findById(id);
		return person.get();
	}
	
	public Person save(Person person) {
		return personRepository.save(person);
	}
	
	public void delbyId(Person person) {
		personRepository.delete(person);
	}
	
	public Person findByCpf(String cpf) {
		return personRepository.findByCpf(cpf);
	}
}
