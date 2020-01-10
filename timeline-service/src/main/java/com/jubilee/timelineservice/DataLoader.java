package com.jubilee.timelineservice;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jubilee.timelineservice.models.Post;
import com.jubilee.timelineservice.repositories.PostRepository;

@Component
public class DataLoader {

    @Autowired
    private PostRepository postRepository;

    //method invoked during the startup
    @PostConstruct
    public void loadData() {
//    	{
//    		Post p = new Post();
//    		p.setContent("content");
//    		p.setOwner("jxcode");
//    		postRepository.save(p);    		
//    	}
//    	
//    	{
//    		Post p = new Post();
//    		p.setContent("content2");
//    		p.setOwner("stpig");
//    		postRepository.save(p);    		
//    	}
//    	
//    	{
//    		Post p = new Post();
//    		p.setContent("content3");
//    		p.setOwner("azure");
//    		postRepository.save(p);    		
//    	}
//    	System.out.println("seeded...!!!");
    }

    //method invoked during the shutdown
    @PreDestroy
    public void removeData() {
//    	postRepository.deleteAll();
    }
}