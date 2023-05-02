package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

@SpringBootApplication

public class MongodbProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongodbProjectApplication.class, args);
	}


}
