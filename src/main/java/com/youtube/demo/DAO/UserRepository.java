package com.youtube.demo.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.youtube.demo.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

	@SuppressWarnings("unchecked")
	User save(User user);
	
}