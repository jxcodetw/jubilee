package com.jubilee.authservice.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Data;

@Data
@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable=false, length=20, unique=true)
	@Length(min=2, max=20)
	private String username;
	
	@Column(nullable=false)
	@JsonProperty(access = Access.WRITE_ONLY)
	private String password;
	
	@CreationTimestamp
    protected Date createdAt;
	
	@UpdateTimestamp
    protected Date updatedAt;
}
