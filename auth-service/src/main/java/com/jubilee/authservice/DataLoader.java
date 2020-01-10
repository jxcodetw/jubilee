package com.jubilee.authservice;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.jubilee.authservice.models.User;
import com.jubilee.authservice.repositories.UserRepository;

@Component
public class DataLoader {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostConstruct
    public void loadData() {
//		{
//			User user = new User();
//			user.setUsername("jxcode");
//			user.setPassword(passwordEncoder.encode("uccujxcode"));
//			userRepository.save(user);
//		}
//		
//		System.out.println("Seeded...!!!");
	}
}
