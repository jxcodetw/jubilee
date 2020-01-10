package com.jubilee.test.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jubilee.test.models.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
	List<Post> findByOwnerUsernameIn(List<String> usernams);
}