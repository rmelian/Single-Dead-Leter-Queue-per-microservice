package com.consumer.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@SpringBootApplication
@EnableBinding(ChannelsService.class)
public class ConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerApplication.class, args);
	}

	@Autowired
	ChannelsService channelsService;

	@StreamListener(ChannelsService.CONSUME_ORDER_CHANGE)
	public void handle(Person person) {
		System.out.println("handle Received: " + person);
//		throw new RuntimeException("handle error");
	}

	@StreamListener(ChannelsService.CONSUME_ORDER_STATUS_CHANGE)
	public void handleStatus(Person person) {
		System.out.println("handleStatus Received: " + person);
//		throw new RuntimeException("handleStatus error");
	}

	public static class Person {
		private String name;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String toString() {
			return this.name;
		}
	}

}
