package com.jubilee.timelineservice.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable=false)
	private String content;
	
	@Column(nullable=false)
	private String owner;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Comment> comments;

	@CreationTimestamp
    protected Date createdAt;
	
	@UpdateTimestamp
    protected Date updatedAt;
	
	public void addComment(Comment comment) {
		comment.setPost(this);
		this.comments.add(comment);
	}
}
