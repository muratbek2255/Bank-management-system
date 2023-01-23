package com.example.Bank_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SQLConnect {

	public static final String DB_USERNAME = "";
	public static final String DB_PASSWORD = "";
	public static final String DB_DATABASE = "";

	public static void main(String[] args){
		SpringApplication.run(SQLConnect.class, args);
	}

}
