package com.sgpd.br.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sgpd.br.entities.Person;
import com.sgpd.br.services.PersonService;

@RestController
@RequestMapping(value = "/persons")
public class PersonResource {
	
	@Autowired
	private PersonService personService;
	
	@GetMapping
	public ResponseEntity<List<Person>> findAll(){
		List<Person> list = personService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Person> findById(@PathVariable Long id){
		Person person = personService.findbyId(id);
		return ResponseEntity.ok().body(person);
	}

}
