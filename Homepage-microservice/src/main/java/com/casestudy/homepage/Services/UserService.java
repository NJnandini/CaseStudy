package com.casestudy.homepage.Services;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.casestudy.homepage.Repositories.UserRepository;
import com.casestudy.homepage.models.UserModel;

@Service
public class UserService implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserModel foundeduser = userRepository.findByUsername(username);
		if(foundeduser == null)
			return null;
		
		String name = foundeduser.getUsername();
		String pwd = foundeduser.getPassword();
		
		return new User(name, pwd, new ArrayList<>());
	}

}
