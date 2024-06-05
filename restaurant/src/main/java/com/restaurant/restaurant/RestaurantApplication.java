package com.restaurant.restaurant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;


@SpringBootApplication
public class RestaurantApplication {
	public static void main(String[] args) {
		SpringApplication.run(RestaurantApplication.class, args);
	}

	@Bean
	public PasswordEncoder getPasswordEncoder(){return new BCryptPasswordEncoder();
	}

}
