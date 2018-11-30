package com.youtube.demo.service;

import java.util.List;

import com.youtube.demo.model.User;

public interface UserService {
	
	User save(User user);
	
	List<User> findAll();
	
	void deleteUser(User user);
}
