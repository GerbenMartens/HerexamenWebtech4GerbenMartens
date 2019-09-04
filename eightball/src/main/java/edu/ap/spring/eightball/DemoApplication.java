package edu.ap.spring.eightball;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

import edu.ap.spring.eightball.Controller.RedisController;
import edu.ap.spring.eightball.redis.RedisService;

@SpringBootApplication
public class DemoApplication {

	private String CHANNEL = "edu:ap:redis";
	@Autowired
	private RedisService service;
	
	@Bean
	RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory,
																					MessageListenerAdapter listenerAdapter) {

		RedisMessageListenerContainer container = new RedisMessageListenerContainer();
		container.setConnectionFactory(connectionFactory);
		container.addMessageListener(listenerAdapter, new ChannelTopic(CHANNEL));

		return container;
	}
	
	@Bean
  public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return (args) -> {

			// empty db
			this.service.flushDb();
	 		
	 		// keys
	 		service.setKey("edu:ap:test", "Key from Spring Boot");
	 		System.out.println(service.getKey("edu:ap:test"));
	 		
	 		// bitops
	 		String bitKey = "edu:ap:bits";
	 		service.setBit(bitKey, 73, true);
	 		service.setBit(bitKey, 85, true);
	 		service.setBit(bitKey, 90, true);
	 		System.out.println(bitKey + ", bit 73 : " + service.getBit(bitKey, 73));
	 		System.out.println(bitKey + ", bit count : " + service.bitCount(bitKey));
	 		
			 // movies
			 
		};
  }

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}


}
