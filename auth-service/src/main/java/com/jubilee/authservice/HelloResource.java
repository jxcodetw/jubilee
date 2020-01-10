package com.jubilee.authservice;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloResource {

	@RequestMapping("/hello")
	public String hello(Authentication authentication) {
		return "wow amazing:" + authentication.getName();
	}
}
