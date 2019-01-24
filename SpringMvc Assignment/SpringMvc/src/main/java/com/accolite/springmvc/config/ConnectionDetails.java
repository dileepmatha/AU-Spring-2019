package com.accolite.springmvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.accolite.springmvc.dao.ConnectionClasstoDatabase;

@Configuration
@ComponentScan("com.accolite.springmvc.dao")
public class ConnectionDetails {
	
	public ConnectionDetails() {
		
	}
	@Bean
	public ConnectionClasstoDatabase userdao() {
		return new ConnectionClasstoDatabase("com.mysql.jdbc.Driver","jdbc:mysql://localhost:3306/hibernate_assg","root","root");
	}
}
