package com.jubilee.test.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity
public class Post {
	@Id
	@GeneratedValue()
	private Integer id;
	
	@Column(nullable=false)
	private String content;
	
	@OneToOne
	private User owner;
	
	@CreationTimestamp
    protected Date createdAt;
	
	@UpdateTimestamp
    protected Date updatedAt;
}
