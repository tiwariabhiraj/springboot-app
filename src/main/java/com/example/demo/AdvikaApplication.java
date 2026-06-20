package com.example.demo;

import API.CustomSorting;
import API.ReentrantLockEx;
import API.StreamsExample;
import DesignPattern.Decorator;
import DesignPattern.ProxyDesignPattern;
import DesignPattern.StateDesignPattern;
import EcecutorServiceEx.ExecuterServiceExamp;
import EcecutorServiceEx.ScheduledThreadPoolExample;
import EcecutorServiceEx.ThreadInterrupt;
import EcecutorServiceEx.ThreadPoolExecutorsEx;
import SystemDesign.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.concurrent.CyclicBarrier;


@SpringBootApplication(scanBasePackages = {
		"com.example.demo",
		"API",
		"Config",
		"Security",
		"AOP_Package"
})
public class AdvikaApplication implements CommandLineRunner {

	private final ApplicationContext context;

	public AdvikaApplication(ApplicationContext context) {
		this.context = context;
	}

	@Value("${server.port:8080}")
	private String port;

	public static void main(String[] args) {
		SpringApplication.run(AdvikaApplication.class, args);
	}

	@Override
	public void run(String... args) {

		System.out.println("\n\n\033[31m================ Application started on port: " + port + " =======================\033[0m\n\n");
						TestCode.start();

//		CustomSorting.start();

//		BeanFlow service = context.getBean(BeanFlow.class);
//		service.pay();
//		ReentrantLockEx.start();
//		ExecuterServiceExamp.start();
//		ThreadInterrupt.start();
//		ThreadPoolExecutorsEx.start();
//		ScheduledThreadPoolExample.start();
//		URLShortner.start();
//		LRU.start();
//		SlidingWindowRateLimiter.start();
//		RateLimiterSliding.start();
//		AutoCompleteSystem.start();
//		ProducerConsumer.start();
//		ProducerConsumerBlockingQueue.start();
//	ConsistentHashing.start();
//		StreamsExample.start();
//		StarvationExample.start();
//		LivelockExample.start();
//		SemaphoreEx.start();
//		CyclicBarrierEx.start();
//		CountDownLatchEx.start();
//Java17Feature.start();


//		Decorator.start();
//		ProxyDesignPattern.start();
//		StateDesignPattern.start();
	}
}