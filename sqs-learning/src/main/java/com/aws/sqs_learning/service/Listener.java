package com.aws.sqs_learning.service;

import io.awspring.cloud.sqs.operations.SqsTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class Listener {
    @Autowired
    private SqsTemplate sqsTemplate;

    // not polling continuously
    public void listen(){
        Optional<Message<?>> result = sqsTemplate.receive();
        System.out.println("message received " + (result.isPresent()? result.get() : "still processing"));
    }
}
