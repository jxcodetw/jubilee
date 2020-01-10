package com.jubilee.timelineservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jubilee.timelineservice.repositories.CommentRepository;

@RestController
@RequestMapping("/comments")
public class CommentController {
	@Autowired
	private CommentRepository commentRepository;
}
