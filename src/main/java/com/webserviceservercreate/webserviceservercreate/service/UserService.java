package com.webserviceservercreate.webserviceservercreate.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webserviceservercreate.webserviceservercreate.dto.UserDto;
import com.webserviceservercreate.webserviceservercreate.exceptions.NotFoundException;
import com.webserviceservercreate.webserviceservercreate.model.User;
import com.webserviceservercreate.webserviceservercreate.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public User postUser(User user)
	{
		return userRepository.save(user);
	}
	
	public ResponseEntity<HttpStatus> updateUser(User user, Long id)
	{
		
		Optional<User> userExistence = userRepository.findById(id);				
		if(!userExistence.isPresent())
		{
			System.out.println("Saving cuz of null");
			userRepository.save(user);	
			return new ResponseEntity<>(HttpStatus.CREATED);
		} else {
			User userRec = userExistence.get();
			userRec.setUsername(user.getUsername());
			userRec.setAddress(user.getAddress());
			userRec.setRollno(user.getRollno());
			userRepository.save(userRec);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		
	}
	
	public UserDto getUserById(Long id) throws NotFoundException
	{
		UserDto userDto = new UserDto();
		Optional<User> userResult = userRepository.findById(id);
		if(!userResult.isPresent()) {
			throw new NotFoundException("User not found");
		}
//		User userObj = userResult.get();
//		userDto.setId(userObj.getId());
//		userDto.setRollno(userObj.getRollno());
//		userDto.setAddress(userObj.getAddress());
//		userDto.setUsername(userObj.getUsername());
		return userDto;		
	}
	
	public List<UserDto> getUserDetails()
	{
		Iterator<User> userRecords = userRepository.findAll().iterator();
		List<UserDto> userDtos = new ArrayList<UserDto>();
		while(userRecords.hasNext())
		{
			UserDto userDto = new UserDto();
			User userDto1 = userRecords.next();
//			System.out.println("address="+userDto1.getAddress());
//			System.out.println("rollno="+userDto1.getRollno());
//			System.out.println("username="+userDto1.getUsername());
			userDto.setId(userDto1.getId());
			userDto.setRollno(userDto1.getRollno());
			userDto.setAddress(userDto1.getAddress());
			userDto.setUsername(userDto1.getUsername());	
			userDtos.add(userDto);
		}
		return userDtos;
	}
	
	

}
