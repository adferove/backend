package com.youtube.demo.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.youtube.demo.model.User;
import com.youtube.demo.service.UserService;
import com.youtube.demo.util.RestResponse;
import com.youtube.demo.util.Tools;

@RestController
public class UserController {

	@Autowired
	protected UserService userService;
	
	protected ObjectMapper mapper;
	
	/**
	 * Exponer servicio
	 * @param userJson
	 * @return
	 */
	@RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
	public RestResponse saveOrUpdate(@RequestBody String userJson) {
		try {
			this.mapper = new ObjectMapper();
			User user = this.mapper.readValue(userJson, User.class);
			if(!validate(user)) {
				return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(), "Los campos obligatorios no estan diligencidos");
			}
			this.userService.save(user);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new RestResponse(HttpStatus.OK.value(), "Operacion exitosa");
	}
	
	@RequestMapping(value = "/getUsers", method = RequestMethod.GET)
	public List<User> getUsers(){
		return this.userService.findAll();
	}
	
	@RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
	public void deleteUser(@RequestBody String userJson) {
		try {
			this.mapper = new ObjectMapper();
			User user = this.mapper.readValue(userJson, User.class);
			if(user.getId()!=null) {
				this.userService.deleteUser(user);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private boolean validate(User user) {
		if(!Tools.isStringNotNull(user.getFirstName())) {
			return false;
		}
		if(!Tools.isStringNotNull(user.getSurname())) {
			return false;
		}
		return true;
	}
	
}
