package com.webserviceservercreate.webserviceservercreate.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.webserviceservercreate.webserviceservercreate.model.User;

public interface UserRepository extends CrudRepository<User, Long>{

	@Query(value="from User where username=?1 and rollno=?2")
	List<User> findByUsernameRollno(String username,Long rollno);
	
//	@Query(value="update User ")
//	List<User> updateUserRecords(String username, Long rollno, String address);
	
	@Modifying(clearAutomatically = true)
    @Query("UPDATE User u SET u.address = :address WHERE u.username = :username")
    int updateUserRecords(String username, String address);
	
}
