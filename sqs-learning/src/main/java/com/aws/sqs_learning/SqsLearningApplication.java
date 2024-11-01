package com.aws.sqs_learning;

import com.aws.sqs_learning.service.Listener;
import com.aws.sqs_learning.service.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SqsLearningApplication implements CommandLineRunner {
	@Autowired
	private Sender sender;
	@Autowired
	private Listener listener;

	public static void main(String[] args) {
		SpringApplication.run(SqsLearningApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
//		sender.sendMessage();
		listener.listen();
	}
}
