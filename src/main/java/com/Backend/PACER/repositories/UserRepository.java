package com.Backend.PACER.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Backend.PACER.entities.User;

public interface UserRepository extends JpaRepository<User,Long> {
	
}
