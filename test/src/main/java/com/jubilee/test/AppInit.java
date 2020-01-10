package com.jubilee.test;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jubilee.test.models.Post;
import com.jubilee.test.models.User;
import com.jubilee.test.repositories.PostRepository;
import com.jubilee.test.repositories.UserRepository;

@Component
class AppInit {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	private void follow(String un1, String un2) {
		User u1 = userRepository.findByUsername(un1);
		User u2 = userRepository.findByUsername(un2);
		u1.follow(u2);
		userRepository.save(u1);
	}
 
    @PostConstruct
    private void init() {
    	for(int i=0;i<3;++i) {
    		User user = new User();
    		user.setUsername("jxcode" + i);
    		user.setPassword("password");
    		userRepository.save(user);
    		
    		for(int h=0;h<3;++h) {
    			User user0 = userRepository.findByUsername("jxcode"+i);
    			Post post = new Post();
    			post.setContent("2020-" + h);
    			user0.addPost(post);
    			
    			postRepository.save(post);
    			userRepository.save(user0);    		
    		}
    	}
    	
		
		User found = userRepository.findByUsername("jxcode0");
		System.out.println(found.getUsername());
		for(Post p : found.getPosts()) {
			System.out.println(p.getId() + " " + p.getContent());
		}
		
		follow("jxcode0", "jxcode1");
//		follow("jxcode0", "jxcode2");
		
//		follow("jxcode1", "jxcode0");
		
		
		List<Post> posts = postRepository.findByOwnerUsernameIn(Arrays.asList(new String[] {"jxcode0", "jxcode1", "jxcode2"}));
		System.out.println(posts.size());
		
		System.out.println("emulating modifying posts");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Post p = postRepository.findById(1).get();
		p.setContent("fuck updated");
//		p.setUpdatedAt(updatedAt);
		postRepository.save(p);
		
    	System.out.println("done!!");
    	
    }
    
}
 