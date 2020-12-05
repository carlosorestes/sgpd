package com.sgpd.br.resources;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sgpd.br.entities.Person;
import com.sgpd.br.response.PersonResponse;
import com.sgpd.br.services.PersonService;

@RestController
@RequestMapping(value = "/persons")
public class PersonResource {
	
	@Autowired
	private PersonService personService;
	
	@GetMapping
	public ResponseEntity<List<Person>> findAll(){
		List<Person> list =  StreamSupport.stream(personService.findAll().spliterator(), false)
			    .collect(Collectors.toList());
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/pageable")
	public PersonResponse retrievePerson(@Param(value = "cpf") String cpf,
								   @Param(value = "page") int page, 
								   @Param(value = "size") int size){
		
		Page<Person> persons = null;
		
		Pageable requestedPage = PageRequest.of(page, size, Sort.by("id").descending());
		persons = personService.findAllPageable(requestedPage);
		
		PersonResponse res = new PersonResponse(persons.getContent(), persons.getTotalPages(), persons.getNumber(), persons.getSize());

		return res;
		
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Person> findById(@PathVariable Long id){
		Person person = personService.findbyId(id);
		return ResponseEntity.ok().body(person);
	}
	
	@GetMapping(value = "/cpf/{cpf}")
	@ResponseBody
	public ResponseEntity<Person> findByCpf(@PathVariable String cpf){
		Person person = personService.findByCpf(cpf);
		return ResponseEntity.ok().body(person);
	}
	
	@PostMapping
	public Person create(@RequestBody Person person) {
		personService.save(person);
		return person;
	}
	
	@DeleteMapping(path = { "/{id}" })
	public Person delete(@PathVariable("id") Long id) {
		Person person = null;
		person = personService.findbyId(id);
		personService.delbyId(person);
		return person;
	}

}
