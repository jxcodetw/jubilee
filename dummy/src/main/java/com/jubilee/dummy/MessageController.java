package com.jubilee.dummy;

import java.util.Random;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
	
	@Value("${message:noconfigformessage}")
	private String message;
	
	@Value("${eureka.instance.instance-id:noconfigforid}")
	private String randomID;
	
	@RequestMapping("/message")
	String message() {
		String ret = "";
		ret = "message: " + this.message + "\n";
		ret += "id: " + this.randomID + "\n";
		return ret;
	}	
}