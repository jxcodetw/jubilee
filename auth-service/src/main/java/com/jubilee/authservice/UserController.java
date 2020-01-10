package com.jubilee.authservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jubilee.authservice.models.User;
import com.jubilee.authservice.repositories.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@RequestMapping(value="/new", method=RequestMethod.POST)
	public User addUser(@RequestBody User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		User new_user = userRepository.save(user);
		return new_user;
	}
	
	@RequestMapping(value="/exists/{username}", method=RequestMethod.GET)
	public Boolean userExists(@PathVariable("username") String username) {
		return !userRepository.findByUsername(username).isEmpty();
	}
}
