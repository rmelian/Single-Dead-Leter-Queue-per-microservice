package com.producer.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableBinding(Source.class)
@EnableScheduling
public class ProducerApplication {


	public static void main(String[] args) {
		SpringApplication.run(ProducerApplication.class, args);

	}

}

@Component
class MyPublisher {

	@Autowired
	private Source source;

	@Scheduled(fixedDelay=10)
	public void message1() {
		System.out.println("sending message");
		source.output().send(MessageBuilder.withPayload(new Person( "Raimar the great 1")).build());
	}

	@Scheduled(fixedDelay=10)
	public void message2() {
		System.out.println("sending message");
		source.output().send(MessageBuilder.withPayload(new Person( "Raimar the great 2")).build());
	}

	@Scheduled(fixedDelay=10)
	public void message3() {
		System.out.println("sending message");
		source.output().send(MessageBuilder.withPayload(new Person( "Raimar the great 3")).build());
	}

	@Scheduled(fixedDelay=10)
	public void message4() {
		System.out.println("sending message");
		source.output().send(MessageBuilder.withPayload(new Person( "Raimar the great 4")).build());
	}

	@Scheduled(fixedDelay=10)
	public void message5() {
		System.out.println("sending message");
		source.output().send(MessageBuilder.withPayload(new Person( "Raimar the great 5")).build());
	}

	public static class Person {
		private String name;

		public Person(String name) {
			this.name = name;
		}

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
