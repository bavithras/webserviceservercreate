package com.webserviceservercreate.webserviceservercreate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.webserviceservercreate.webserviceservercreate.dto.UserDto;
import com.webserviceservercreate.webserviceservercreate.exceptions.NotFoundException;
import com.webserviceservercreate.webserviceservercreate.model.User;
import com.webserviceservercreate.webserviceservercreate.repository.UserRepository;
import com.webserviceservercreate.webserviceservercreate.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	UserService userService;
	
	@PostMapping("/user")
	public ResponseEntity<User> saveUser(@RequestBody User user)	
	{
		User userObj = userService.postUser(user);
		return new ResponseEntity<User>(userObj, HttpStatus.CREATED);
	}
	
	@PutMapping("/updateUser/{id}/")
	public ResponseEntity<HttpStatus> updateUser(@RequestBody User user,@PathVariable("id") Long id)
	{
		return userService.updateUser(user, id);
		
	}
	
	@GetMapping("/user/{id}")
	public UserDto getUserById(@PathVariable("id")Long id) throws NotFoundException 
	{
		UserDto userDto = userService.getUserById(id);
		return userDto;
	}
	
	@GetMapping("/user/{username}/{rollno}")
	public List<User> findByUsernameRollno(@PathVariable("username")String username, 
			@PathVariable("rollno")Long rollno)
	{
		List<User> userVal = userRepo.findByUsernameRollno(username, rollno);
		return userVal;
	}
	
	@PutMapping("/user/{username}/{address}")
	@Transactional
	public int updateWithQuery(@PathVariable("username")String username, @PathVariable("address")String address) {
		return userRepo.updateUserRecords(username, address);
	}
	
	@GetMapping("/getusers")
	public List<UserDto> getUserDetails()
	{
		List<UserDto> userDto = userService.getUserDetails();
		return userDto;		
	}


}
