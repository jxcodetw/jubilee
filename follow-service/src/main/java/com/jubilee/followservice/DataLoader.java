package com.jubilee.followservice;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jubilee.followservice.models.Follow;
import com.jubilee.followservice.repositories.FollowRepository;

@Component
public class DataLoader {
	@Autowired
	private FollowRepository followRepository;
	
	@PostConstruct
	public void loadData() {
//		{
//			Follow follow = new Follow();
//			follow.setFollower("jxcode");
//			follow.setFollowee("stpig");
//			followRepository.save(follow);
//		}
//		{
//			Follow follow = new Follow();
//			follow.setFollower("jxcode");
//			follow.setFollowee("azure");
//			followRepository.save(follow);
//		}
//		System.out.println("seeded...!!!");
	}
}
