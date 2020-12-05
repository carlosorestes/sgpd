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
import com.sgpd.br.entities.OrderVehicle;
import com.sgpd.br.entities.Person;
import com.sgpd.br.entities.User;
import com.sgpd.br.entities.Vehicle;
import com.sgpd.br.enums.TipoVeiculo;
import com.sgpd.br.repositories.OrderRepository;
import com.sgpd.br.repositories.OrderVehicleRepository;
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
	
	@Autowired
	private OrderVehicleRepository orderVehicleRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
//		Add User of System
		User user1 = new User(null, "user1", "11111", "user1", "11111", Boolean.TRUE);
		User user2 = new User(null, "user2", "22222", "user1", "22222", Boolean.TRUE);
		
//		Add Client of System
		Person person1 = new Person(null, "Person 111","000000000", "33333333333", "333333333");
		Person person2 = new Person(null, "Person 222","111111111", "44444444444", "555555555");
				
		Vehicle v1 = new Vehicle(null, 2020, "Modelo 01", "Cor 01", "PPPPPP01", "XXXXXXXX01", TipoVeiculo.MOTOCICLETA);
		Vehicle v2 = new Vehicle(null, 2020, "Modelo 02", "Cor 02", "PPPPPP02", "XXXXXXXX02", TipoVeiculo.MOTONETA);
		Vehicle v3 = new Vehicle(null, 2020, "Modelo 03", "Cor 03", "PPPPPP03", "XXXXXXXX03", TipoVeiculo.CAMINHAOTRATOR);
		Vehicle v4 = new Vehicle(null, 2020, "Modelo 04", "Cor 04", "PPPPPP04", "XXXXXXXX04", TipoVeiculo.CAMINHAO);
		Vehicle v5 = new Vehicle(null, 2020, "Modelo 05", "Cor 05", "PPPPPP05", "XXXXXXXX05", TipoVeiculo.MICROONIBUS);
		
		
		
		Vehicle v10 = new Vehicle(null, 2020, "Modelo 01", "Cor 01", "GGGGGG01", "YYYYYYYY01", TipoVeiculo.MOTOCICLETA);
		Vehicle v20 = new Vehicle(null, 2020, "Modelo 02", "Cor 02", "GGGGGG02", "YYYYYYYY02", TipoVeiculo.MOTONETA);
		Vehicle v30 = new Vehicle(null, 2020, "Modelo 03", "Cor 03", "GGGGGG03", "YYYYYYYY03", TipoVeiculo.CAMINHAOTRATOR);
		Vehicle v40 = new Vehicle(null, 2020, "Modelo 04", "Cor 04", "GGGGGG04", "YYYYYYYY04", TipoVeiculo.CAMINHAO);
		Vehicle v50 = new Vehicle(null, 2020, "Modelo 05", "Cor 05", "GGGGGG05", "YYYYYYYY05", TipoVeiculo.MICROONIBUS);
		
		
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), user1, person1, new Date(),new Date(),new Date(), "Recommendation Teste", "Note Teste", null);
		Order o2 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), user1, person1, new Date(),new Date(),new Date(), "Recommendation Teste", "Note Teste", null);
		
		userRepository.saveAll(Arrays.asList(user1, user2));
		
		personRepository.saveAll(Arrays.asList(person1, person2));
		
		vehicleRepository.saveAll(Arrays.asList(v1, v2, v3, v4, v5, v10, v20, v30, v40, v50));
		
		o1 = orderRepository.save(o1);
		o2 = orderRepository.save(o2);
		
		OrderVehicle orderVehicle1 = new OrderVehicle(o1, v1, "111111");
		OrderVehicle orderVehicle2 = new OrderVehicle(o1, v2, "222222");
		OrderVehicle orderVehicle3 = new OrderVehicle(o1, v3, "333333");
		OrderVehicle orderVehicle4 = new OrderVehicle(o1, v4, "444444");
		OrderVehicle orderVehicle5 = new OrderVehicle(o1, v5, "555555");
		o1.getListOrderVehicle().addAll(Arrays.asList(new OrderVehicle[] {orderVehicle1, orderVehicle2, orderVehicle3, orderVehicle4, orderVehicle5}));
		
		OrderVehicle orderVehicle10 = new OrderVehicle(o2, v10, "666666");
		OrderVehicle orderVehicle20 = new OrderVehicle(o2, v20, "777777");
		OrderVehicle orderVehicle30 = new OrderVehicle(o2, v30, "888888");
		OrderVehicle orderVehicle40 = new OrderVehicle(o2, v40, "999999");
		OrderVehicle orderVehicle50 = new OrderVehicle(o2, v50, "101010");
		o2.getListOrderVehicle().addAll(Arrays.asList(new OrderVehicle[] {orderVehicle10, orderVehicle20, orderVehicle30, orderVehicle40, orderVehicle50}));
		
		orderVehicleRepository.saveAll(Arrays.asList(orderVehicle1, orderVehicle2, orderVehicle3, orderVehicle4, orderVehicle5,
				orderVehicle10, orderVehicle20, orderVehicle30, orderVehicle40, orderVehicle50));
	}
}
