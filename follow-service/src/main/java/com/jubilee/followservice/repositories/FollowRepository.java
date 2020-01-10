package com.jubilee.followservice.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jubilee.followservice.models.Follow;

@Repository
public interface FollowRepository extends JpaRepository<Follow, Integer> {
	List<Follow> findByFollower(String name);
	List<Follow> findByFollowee(String name);
//	@Transactional
	Integer deleteByFollowerAndFollowee(String follower, String followee);
}
