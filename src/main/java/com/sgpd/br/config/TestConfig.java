package com.sgpd.br.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.sgpd.br.entities.User;
import com.sgpd.br.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		User user1 = new User(null, "user1", "11111", "11111");
		User user2 = new User(null, "user2", "22222", "22222");
		
		userRepository.saveAll(Arrays.asList(user1, user2));
	}
}
