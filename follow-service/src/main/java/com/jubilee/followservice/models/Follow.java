package com.jubilee.followservice.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity
@Table(uniqueConstraints={
		@UniqueConstraint(columnNames = {"follower", "followee"})
}) 
public class Follow {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable=false)
	private String follower;
	
	@Column(nullable=false)
	private String followee;
	
	@CreationTimestamp
    protected Date createdAt;
	
	@UpdateTimestamp
    protected Date updatedAt;
}
