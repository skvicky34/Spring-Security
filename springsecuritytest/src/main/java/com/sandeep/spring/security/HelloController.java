package com.sandeep.spring.security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@GetMapping("/hello")
	public String hello()
	{
		return "Spring Security Test";
		
	}
	
	@GetMapping("/bye")
	public String bye()
	{
		return "Bye Bye!!!";
		
	}

}
