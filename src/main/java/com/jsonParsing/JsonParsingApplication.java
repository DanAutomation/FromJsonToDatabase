package com.jsonParsing;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jsonParsing.domain.User;
import com.jsonParsing.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class JsonParsingApplication {

	public static void main(String[] args) {
		SpringApplication.run(JsonParsingApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(UserService userService) {
		return args -> {
			// read json and write to DB
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<User>> typeReference = new TypeReference<List<User>>(){};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/users.json");
			try {
				List<User> users = mapper.readValue(inputStream, typeReference);
				userService.save(users);
				System.out.println("user saved");
			} catch (IOException e){
				System.out.println("unable to save users: " + e.getMessage());
			}



		};
	}


}
