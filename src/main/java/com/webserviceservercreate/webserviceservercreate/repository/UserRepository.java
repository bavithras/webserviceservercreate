package com.webserviceservercreate.webserviceservercreate.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.webserviceservercreate.webserviceservercreate.model.User;

public interface UserRepository extends CrudRepository<User, Long>{

	
	
}
