package com.devtech;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testhttp {

	@RequestMapping("/hello")
	public String sayHi() {
		
		return "Hello";
		
	}
	
}
