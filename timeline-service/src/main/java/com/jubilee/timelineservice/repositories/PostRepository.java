package com.jubilee.timelineservice.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jubilee.timelineservice.models.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
	List<Post> findByOwner(String owner);
	List<Post> findByOwnerInOrderByCreatedAtDesc(List<String> owners);
}
