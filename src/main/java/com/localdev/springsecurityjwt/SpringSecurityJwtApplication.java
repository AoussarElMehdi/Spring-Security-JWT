package com.localdev.springsecurityjwt;

import java.util.ArrayList;

import com.localdev.springsecurityjwt.entity.Role;
import com.localdev.springsecurityjwt.entity.User;
import com.localdev.springsecurityjwt.service.UserService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SpringSecurityJwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityJwtApplication.class, args);
	}

	@Bean
	BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(UserService userService) {
		return args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_MANAGER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

			userService.saveUser(new User(null, "Mehdi One", "mehdi1", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "Mehdi Two", "mehdi2", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "Mehdi Three", "mehdi3", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "Mehdi Four", "mehdi4", "1234", new ArrayList<>()));

			userService.addRoleToUser("mehdi1", "ROLE_USER");
			userService.addRoleToUser("mehdi2", "ROLE_MANAGER");
			userService.addRoleToUser("mehdi3", "ROLE_ADMIN");
			userService.addRoleToUser("mehdi4", "ROLE_SUPER_ADMIN");
			userService.addRoleToUser("mehdi4", "ROLE_ADMIN");
			userService.addRoleToUser("mehdi4", "ROLE_USER");
		};
	}

}
