package com.jubilee.timelineservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jubilee.timelineservice.models.Post;
import com.jubilee.timelineservice.repositories.PostRepository;
import com.jubilee.timelineservice.services.FollowService;

@RestController
@RequestMapping("/timeline")
public class TimelineController {
	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private FollowService followService;
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public List<Post> findAll(Authentication authentication) {
		List<String> usersToShow = followService.findFollowee(authentication.getName());
		usersToShow.add(authentication.getName());
		return postRepository.findByOwnerInOrderByCreatedAtDesc(usersToShow);
	}
}
