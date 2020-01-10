package com.jubilee.test.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class User {
	@Id
	private String username;
	
	@Column(nullable=false)
	private String password;
	
	@OneToMany()
	private List<User> follows;
	
	public void follow(User user) {
		follows.add(user);
	}
	
	@OneToMany()
	private List<Post> posts = new ArrayList<>();
	
	public void addPost(Post post) {
		posts.add(post);
		post.setOwner(this);
	}
}
