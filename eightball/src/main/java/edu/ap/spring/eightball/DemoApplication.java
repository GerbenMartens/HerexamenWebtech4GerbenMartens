package edu.ap.spring.eightball;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	private String CHANNEL = "edu:ap:redis";
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
