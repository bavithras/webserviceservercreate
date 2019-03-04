package com.webserviceservercreate.webserviceservercreate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.webserviceservercreate.webserviceservercreate.model.User;
import com.webserviceservercreate.webserviceservercreate.repository.UserRepository;
import com.webserviceservercreate.webserviceservercreate.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	UserService userService;
	
	@PostMapping("/User")
	public void saveUser(@RequestBody User user)	
	{
		userService.postUser(user);
	}
	
	@PutMapping("/updateUser/{id}/")
	public void updateUser(@RequestBody User user,@PathVariable("id") Long id)
	{
		userService.updateUser(user, id);
	}


}
