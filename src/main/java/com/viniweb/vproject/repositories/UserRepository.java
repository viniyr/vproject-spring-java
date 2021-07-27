package com.viniweb.vproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.viniweb.vproject.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

	
}
