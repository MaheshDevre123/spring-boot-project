package com.security;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringSecurity7Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurity7Application.class, args);
	}
	
	 @Bean
	  public ModelMapper modelMapper() {
	    return new ModelMapper();
	  }

}
