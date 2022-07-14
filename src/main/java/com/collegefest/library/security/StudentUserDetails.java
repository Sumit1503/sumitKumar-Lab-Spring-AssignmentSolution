package com.collegefest.library.security;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.collegefest.library.entity.Roles;
import com.collegefest.library.entity.User;

public class StudentUserDetails implements UserDetails {
	
	private User user;
	
	
	public StudentUserDetails(User user) {
		super();
		this.user = user;
	}

	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<Roles> rolesList = user.getRoles();
		List<SimpleGrantedAuthority> grantedAuthorities= new ArrayList<>();
		for(Roles role:rolesList)
		{
			grantedAuthorities.add(new SimpleGrantedAuthority(role.getRoleName()));
		}
		return grantedAuthorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getUserName();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
