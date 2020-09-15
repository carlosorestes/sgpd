package com.sgpd.br.config;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.sgpd.br.entities.Order;
import com.sgpd.br.entities.Person;
import com.sgpd.br.entities.User;
import com.sgpd.br.entities.Vehicle;
import com.sgpd.br.enums.TipoVeiculo;
import com.sgpd.br.repositories.OrderRepository;
import com.sgpd.br.repositories.PersonRepository;
import com.sgpd.br.repositories.UserRepository;
import com.sgpd.br.repositories.VehicleRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private VehicleRepository vehicleRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
//		Add User of System
		User user1 = new User(null, "user1", "11111", "11111", "ativo");
		User user2 = new User(null, "user2", "22222", "22222", "ativo");
		
//		Add Client of System
		Person person1 = new Person(null, "Person 111","000000000", "33333333333", "333333333");
		Person person2 = new Person(null, "Person 222","111111111", "44444444444", "555555555");
				
		Vehicle v1 = new Vehicle(null, 2020, "Modelo 01", "Cor 01", "Placa 01", "Renavam 01", TipoVeiculo.MOTOCICLETA);
		Vehicle v2 = new Vehicle(null, 2020, "Modelo 02", "Cor 02", "Placa 02", "Renavam 02", TipoVeiculo.MOTONETA);
		Vehicle v3 = new Vehicle(null, 2020, "Modelo 03", "Cor 03", "Placa 03", "Renavam 03", TipoVeiculo.CAMINHAOTRATOR);
		Vehicle v4 = new Vehicle(null, 2020, "Modelo 04", "Cor 04", "Placa 04", "Renavam 04", TipoVeiculo.CAMINHAO);
		Vehicle v5 = new Vehicle(null, 2020, "Modelo 05", "Cor 05", "Placa 05", "Renavam 05", TipoVeiculo.MICROONIBUS);
		
		
		
		Vehicle v10 = new Vehicle(null, 2020, "Modelo 01", "Cor 01", "Placa 01", "Renavam 01", TipoVeiculo.MOTOCICLETA);
		Vehicle v20 = new Vehicle(null, 2020, "Modelo 02", "Cor 02", "Placa 02", "Renavam 02", TipoVeiculo.MOTONETA);
		Vehicle v30 = new Vehicle(null, 2020, "Modelo 03", "Cor 03", "Placa 03", "Renavam 03", TipoVeiculo.CAMINHAOTRATOR);
		Vehicle v40 = new Vehicle(null, 2020, "Modelo 04", "Cor 04", "Placa 04", "Renavam 04", TipoVeiculo.CAMINHAO);
		Vehicle v50 = new Vehicle(null, 2020, "Modelo 05", "Cor 05", "Placa 05", "Renavam 05", TipoVeiculo.MICROONIBUS);
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), user1, person1, new Date(),new Date(),new Date(), "Recommendation Teste", "Note Teste", 
				new ArrayList<Vehicle>(Arrays.asList(new Vehicle[] {v1, v2, v3, v4, v5})));
		
		Order o2 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), user1, person1, new Date(),new Date(),new Date(), "Recommendation Teste", "Note Teste",
				new ArrayList<Vehicle>(Arrays.asList(new Vehicle[] {v10, v20, v30, v40, v50})));
		
		userRepository.saveAll(Arrays.asList(user1, user2));
		
		personRepository.saveAll(Arrays.asList(person1, person2));
		
		vehicleRepository.saveAll(Arrays.asList(v1, v2, v3, v4, v5, v10, v20, v30, v40, v50));
		orderRepository.saveAll(Arrays.asList(o1, o2));
		

//		vehicleRepository.saveAll(Arrays.asList(v10, v20, v30, v40, v50));
	}
}
