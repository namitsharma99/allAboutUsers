package com.code.allAboutUsers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = { "com.code.*" })
@EnableJpaRepositories("com.code.repositories")
@EntityScan("com.code.*")   
public class AllAboutUsersApplication {

	public static void main(String[] args) {
		SpringApplication.run(AllAboutUsersApplication.class, args);
	}

}
