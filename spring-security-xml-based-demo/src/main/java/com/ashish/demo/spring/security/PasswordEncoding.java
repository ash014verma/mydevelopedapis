package com.ashish.demo.spring.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoding {
	public static void main(String[] args) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12); // Strength set as 12  
		String encodedPassword = encoder.encode("123");  
		System.out.println(encodedPassword);
	}
	

}
