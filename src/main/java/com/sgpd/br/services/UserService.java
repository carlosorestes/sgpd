package com.sgpd.br.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgpd.br.entities.User;
import com.sgpd.br.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll(){
		return userRepository.findAll();
	}

	public User findbyId(Long id) {
		Optional<User> user = userRepository.findById(id);
		return user.get();
	}
	
	public void delbyId(User user) {
		userRepository.delete(user);
	}
	
	public User save(User user) {
		return userRepository.save(user);
	}
	
	public User findbyNome(String nome) {
		return userRepository.findByNome(nome);
	}
}
