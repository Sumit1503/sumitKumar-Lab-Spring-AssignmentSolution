package com.collegefest.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.collegefest.library.entity.User;
import com.collegefest.library.repositories.UserRepository;
import com.collegefest.library.security.StudentUserDetails;

public class UserServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) {
		User user = userRepository.getUserByUserName(username);
		
		if(user==null)
		{
			throw new UsernameNotFoundException("User "+username+" not found!!");
		}
		UserDetails studentUserDetails = new StudentUserDetails(user);
		return studentUserDetails;
		
	}

}
