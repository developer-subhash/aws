package com.aws.sqs_learning.service;

import io.awspring.cloud.sqs.annotation.SqsListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class DefaultListener {
    @Value("${aws.queue.name}")
    private String queueName;

    // polling continuously
//    @SqsListener("sqs-learning")
//    public void listen(String message){
//        System.out.println("received message from aws sqs " + message);
//    }
}
