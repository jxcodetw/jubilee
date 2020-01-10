package com.jubilee.timelineservice.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jubilee.timelineservice.models.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
	List<Comment> findByPostIdOrderByCreatedAtAsc(Integer postid);
}
