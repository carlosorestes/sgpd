package com.sgpd.br.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sgpd.br.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	public User findByNome(String nome);
	
}
