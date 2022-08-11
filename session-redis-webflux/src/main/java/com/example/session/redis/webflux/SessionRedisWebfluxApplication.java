package com.example.session.redis.webflux;

import org.springframework.aot.smoketest.thirdpartyhints.NettyRuntimeHints;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportRuntimeHints;

// JVM: 33
// Native image with lettuce & without hints: 0 (THIS IS WRONG, means all are skippable)
// Native image with lettuce & with hints: 33 (Correct, channelRead and exceptionCaught are skippable)
// Native image without lettuce & without hints: 511 (OK, no method is skippable - happens because reflection metadata is missing)
// Native image without lettuce & with hints: 33 (Correct, see above)

@SpringBootApplication
// Uncomment for hints on reactor.netty.transport.ServerTransport$Acceptor
// @ImportRuntimeHints({ NettyRuntimeHints.class, ReactorNettyHints.class })
@ImportRuntimeHints(NettyRuntimeHints.class)
public class SessionRedisWebfluxApplication {

	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(SessionRedisWebfluxApplication.class, args);
		Thread.currentThread().join(); // To be able to measure memory consumption
	}

}
