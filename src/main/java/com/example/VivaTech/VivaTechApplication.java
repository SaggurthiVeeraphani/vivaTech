package com.example.VivaTech;

import com.example.VivaTech.Configuration.TwilioConfiguration;
import com.example.VivaTech.Model.user;
import com.example.VivaTech.Respository.UserRepository;
import com.twilio.Twilio;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
@OpenAPIDefinition( info = @Info(title = "Spring boot otp authentication",version = "1.0.0"))
public class VivaTechApplication {
	@Autowired
	private UserRepository repository;
	@Autowired
	private TwilioConfiguration twilioConfig;

	public static void main(String[] args) {

		SpringApplication.run(VivaTechApplication.class, args);
	}
	@PostConstruct
	public void initTwilio(){
		Twilio.init(twilioConfig.getAccountSid(),twilioConfig.getAuthToken());
	}


	@PostConstruct
	public void initUsers() {
		user user1 = new user();
		user1.setUserName( "7022752477");
		List<user> users = Stream.of(user1
		).collect(Collectors.toList());
		repository.saveAll(users);
	}

}
