package com.jubilee.timelineservice.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable=false)
	private String content;
	
	@Column(nullable=false)
	private String owner;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private Post post;

	@CreationTimestamp
    protected Date createdAt;
	
	@UpdateTimestamp
    protected Date updatedAt;
}