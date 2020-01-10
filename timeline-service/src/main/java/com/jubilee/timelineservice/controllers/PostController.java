package com.jubilee.timelineservice.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jubilee.timelineservice.models.Comment;
import com.jubilee.timelineservice.models.Post;
import com.jubilee.timelineservice.repositories.CommentRepository;
import com.jubilee.timelineservice.repositories.PostRepository;

@RestController
@RequestMapping("/posts")
public class PostController {
	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private CommentRepository commentRepository;
	
	@RequestMapping(value="/findByUsername/{username}", method=RequestMethod.GET)
	public List<Post> findByUsername(@PathVariable("username") String username) {
		return postRepository.findByOwner(username);
	}
	
	@RequestMapping(value="/new", method=RequestMethod.POST)
	public Post newPost(Authentication authentication, @RequestBody Post request) {
		Post post = new Post();
		post.setContent(request.getContent());
		post.setOwner(authentication.getName());
		return postRepository.save(post);
	}
	
	@RequestMapping(value="/{postid}", method=RequestMethod.GET)
	public ResponseEntity<?> findOne(@PathVariable("postid") Integer postid) {
		Optional<Post> query_post = postRepository.findById(postid);
		if (query_post.isPresent()) {
			return ResponseEntity.ok(query_post.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	@RequestMapping(value="/{postid}/comments", method=RequestMethod.GET)
	public List<Comment> getComments(@PathVariable("postid") Integer postid) {
		return commentRepository.findByPostIdOrderByCreatedAtAsc(postid);
	}
	
	@RequestMapping(value="/{postid}/comments/new", method=RequestMethod.POST)
	public ResponseEntity<?> newComment(Authentication authentication, @PathVariable("postid") Integer postid, 
			@RequestBody Comment request) {
		Optional<Post> query_post = postRepository.findById(postid);
		if (query_post.isPresent()) {
			Post post = query_post.get();
			Comment comment = new Comment();
			comment.setContent(request.getContent());
			comment.setOwner(authentication.getName());
			post.addComment(comment);
			Comment saved_comment = commentRepository.save(comment);
			postRepository.save(post);
			return ResponseEntity.ok(saved_comment);
		}
		return ResponseEntity.notFound().build();
	}
}
