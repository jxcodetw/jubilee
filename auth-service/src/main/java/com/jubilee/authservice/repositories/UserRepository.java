package com.jubilee.authservice.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jubilee.authservice.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	List<User> findByUsername(String username);
}
