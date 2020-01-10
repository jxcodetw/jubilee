package com.jubilee.authservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jubilee.authservice.repositories.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		List<com.jubilee.authservice.models.User> query_user = userRepository.findByUsername(username);
		if (query_user.size() == 1) {
			com.jubilee.authservice.models.User user = query_user.get(0);
			System.out.println(user.getUsername());
			return new User(user.getUsername(), user.getPassword(), new ArrayList<>());
		} else {
			System.out.println("Fuck");
			return null;
		}
		
	}

}
