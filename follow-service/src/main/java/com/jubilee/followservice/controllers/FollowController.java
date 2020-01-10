package com.jubilee.followservice.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jubilee.followservice.models.Follow;
import com.jubilee.followservice.repositories.FollowRepository;
import com.jubilee.followservice.services.UserService;

@RestController
public class FollowController {
	@Autowired
	private FollowRepository followRepository;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/findFollowee/{follower}", method=RequestMethod.GET)
	public List<String> findFollowee(@PathVariable("follower") String follower) {
		List<Follow> follows = followRepository.findByFollower(follower);
		return follows.stream().map(f -> f.getFollowee()).collect(Collectors.toList());
	}
	
	@RequestMapping(value="/new", method=RequestMethod.POST)
	public ResponseEntity<?> newFollow(Authentication authentication, 
			@RequestHeader("Authorization") String authorization, 
			@RequestBody Follow request) {
		
		Map<String, String> headers = new HashMap<>();
		headers.put("Authorization", authorization);
		if (!userService.userExists(headers, request.getFollowee())) {
			return new ResponseEntity<>(
			          "Followee doesn't exist.", 
			          HttpStatus.BAD_REQUEST);
		}
		
		
		request.setFollower(authentication.getName());
		Follow follow = followRepository.save(request);
		return ResponseEntity.ok(follow);
		
	}
}
