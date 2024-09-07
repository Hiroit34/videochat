package org.progettipersonali.videochat;

import org.progettipersonali.videochat.user.User;
import org.progettipersonali.videochat.user.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class VideochatApplication {

	public static void main(String[] args) {
		SpringApplication.run(VideochatApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(UserService userService) {
		return args -> {
			userService.register(
					User.builder()
							.username("Franz")
							.email("prova@test.com")
							.password("password")
							.build()
			)
			;userService.register(
					User.builder()
							.username("Ale")
							.email("ale@test.com")
							.password("password")
							.build()
			)
			;userService.register(
					User.builder()
							.username("Franco")
							.email("franco@test.com")
							.password("password")
							.build()
			);
		};
	}

}
