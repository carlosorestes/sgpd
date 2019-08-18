package com.sgpd.br.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sgpd.br.entities.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
	
	
	
}
