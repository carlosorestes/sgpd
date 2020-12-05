package com.sgpd.br.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.sgpd.br.entities.Person;

public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {
	
	Person findByCpf(String cpf);
	
}
