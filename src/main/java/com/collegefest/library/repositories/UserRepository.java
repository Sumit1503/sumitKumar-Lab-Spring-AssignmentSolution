package com.collegefest.library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.collegefest.library.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	@Query("from User u where u.userName=?1 ")
	public User getUserByUserName(String userName);

}
