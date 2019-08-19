package com.sgpd.br.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.sgpd.br.entities.Order;
import com.sgpd.br.entities.Person;
import com.sgpd.br.entities.User;
import com.sgpd.br.repositories.OrderRepository;
import com.sgpd.br.repositories.PersonRepository;
import com.sgpd.br.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
//		Add User of System
		User user1 = new User(null, "user1", "11111", "11111");
		User user2 = new User(null, "user2", "22222", "22222");
		
//		Add Client of System
		Person person1 = new Person(null, "Person 111","000000000", "33333333333", "333333333");
		Person person2 = new Person(null, "Person 222","111111111", "44444444444", "555555555");

		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), user1, person1);
		Order o2 = new Order(null, Instant.parse("2019-06-20T19:54:07Z"), user1, person1);
		Order o3 = new Order(null, Instant.parse("2019-06-20T19:55:07Z"), user1, person1);
		Order o4 = new Order(null, Instant.parse("2019-06-20T19:56:07Z"), user1, person1);
		
		userRepository.saveAll(Arrays.asList(user1, user2));
		
		personRepository.saveAll(Arrays.asList(person1, person2));
		
		orderRepository.saveAll(Arrays.asList(o1,o2,o3,o4));
	}
}
