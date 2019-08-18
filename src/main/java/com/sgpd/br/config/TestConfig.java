package com.sgpd.br.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.sgpd.br.entities.Person;
import com.sgpd.br.entities.User;
import com.sgpd.br.repositories.PersonRepository;
import com.sgpd.br.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PersonRepository personRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
//		Add User of System
		User user1 = new User(null, "user1", "11111", "11111");
		User user2 = new User(null, "user2", "22222", "22222");
		
		userRepository.saveAll(Arrays.asList(user1, user2));
		
//		Add Client of System
		Person person1 = new Person(null, "Person 111","000000000", "33333333333", "333333333");
		Person person2 = new Person(null, "Person 222","111111111", "44444444444", "555555555");
		
		personRepository.saveAll(Arrays.asList(person1, person2));
	}
}
