package com.webserviceservercreate.webserviceservercreate.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webserviceservercreate.webserviceservercreate.model.User;
import com.webserviceservercreate.webserviceservercreate.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public void postUser(User user)
	{
		userRepository.save(user);
	}
	
	public void updateUser(User user, Long id)
	{
		Optional<User> userExistence = userRepository.findById(id);		
		if(userExistence==null)
		{
			System.out.println("Saving cuz of null");
			userRepository.save(user);					
		} else {
			User userRecord = userExistence.get();
			System.out.println(userRecord.getUsername());
			System.out.println(userRecord.getRollno());
			System.out.println(userRecord.getAddress());
			System.out.println("Not null");	
			
		}
		
	}

}
