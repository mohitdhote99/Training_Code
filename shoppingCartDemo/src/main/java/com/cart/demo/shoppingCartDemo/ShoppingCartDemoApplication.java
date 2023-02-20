package com.cart.demo.shoppingCartDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @EnableJpaRepositories : scans the repositories
 * @EnableJpaAuditing: saves the associated tables in the database
 * @EntityScan : scans the entities
 * @author Harshit Srivastava
 */
@SpringBootApplication(scanBasePackages = "com")
@EnableJpaRepositories("com.cart.demo.repo")
@EnableJpaAuditing
@EntityScan("com.cart.demo.model")
public class ShoppingCartDemoApplication{

	public static void main(String[] args) {
		SpringApplication.run(ShoppingCartDemoApplication.class, args);
	}

}
