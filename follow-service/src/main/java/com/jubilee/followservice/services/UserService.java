package com.jubilee.followservice.services;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Component
@FeignClient("auth-service")
public interface UserService {
	@RequestMapping(value="/users/exists/{username}", method=RequestMethod.GET)
	public Boolean userExists(@RequestHeader Map<String, String> headerMap, @PathVariable("username") String username);
}
