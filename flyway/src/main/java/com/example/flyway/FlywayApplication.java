package com.example.flyway;

import org.springframework.aot.smoketest.thirdpartyhints.HikariRuntimeHints;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportRuntimeHints;

@SpringBootApplication
@ImportRuntimeHints(HikariRuntimeHints.class)
public class FlywayApplication {

	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(FlywayApplication.class, args);
		Thread.currentThread().join(); // To be able to measure memory consumption
	}

}
