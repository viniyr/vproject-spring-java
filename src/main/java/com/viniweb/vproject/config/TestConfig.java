package com.viniweb.vproject.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.viniweb.vproject.entities.Order;
import com.viniweb.vproject.entities.User;
import com.viniweb.vproject.repositories.OrderRepository;
import com.viniweb.vproject.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User(null, "Finn Mertens", "finn@gmail.com", "999999999", "123456"); 
		User u2 = new User(null, "Jake the Dog", "jake@gmail.com", "999999992", "123456");
		
		Order o1 = new Order(null, Instant.parse("2021-04-04T19:53:07Z"), u1); 
		Order o2 = new Order(null, Instant.parse("2021-03-22T03:42:10Z"), u2); 
		Order o3 = new Order(null, Instant.parse("2021-03-01T15:21:22Z"), u1);
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
		
	}
	
	
}
