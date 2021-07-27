package com.viniweb.vproject.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.viniweb.vproject.entities.User;
import com.viniweb.vproject.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User(null, "Finn Mertens", "finn@gmail.com", "999999999", "123456"); 
		User u2 = new User(null, "Jake the Dog", "jake@gmail.com", "999999992", "123456");
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		
	}
	
	
}
