package com.example.session.redis.webflux;

import org.springframework.aot.smoketest.thirdpartyhints.NettyRuntimeHints;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportRuntimeHints;

@SpringBootApplication
@ImportRuntimeHints(NettyRuntimeHints.class)
public class SessionRedisWebfluxApplication {

	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(SessionRedisWebfluxApplication.class, args);
		Thread.currentThread().join(); // To be able to measure memory consumption
	}

}
