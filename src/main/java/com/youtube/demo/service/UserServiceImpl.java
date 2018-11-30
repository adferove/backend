package com.youtube.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.youtube.demo.DAO.UserRepository;
import com.youtube.demo.model.User;

//Anotacion de spring framework
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	protected UserRepository userRepository;

	public User save(User user) {
		
		return this.userRepository.save(user);
	}
	
	
	
}
