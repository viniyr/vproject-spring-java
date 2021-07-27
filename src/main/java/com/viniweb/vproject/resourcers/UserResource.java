package com.viniweb.vproject.resourcers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.viniweb.vproject.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@GetMapping
	public ResponseEntity<User> findAll() { 
		User u = new User(1L , "Amanda Ogoshi", "mand_ogoshi@hotmail.com", "99026-2852", "anya&atena");
		return ResponseEntity.ok().body(u);
	}
	
}
