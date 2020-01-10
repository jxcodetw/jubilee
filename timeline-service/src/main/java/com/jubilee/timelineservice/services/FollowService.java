package com.jubilee.timelineservice.services;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Component
@FeignClient("follow-service")
public interface FollowService {
	@RequestMapping(value="/findFollowee/{follower}", method=RequestMethod.GET)
	public List<String> findFollowee(@PathVariable("follower") String follower);
}
