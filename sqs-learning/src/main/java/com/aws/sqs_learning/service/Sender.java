package com.aws.sqs_learning.service;

import io.awspring.cloud.sqs.operations.SendResult;
import io.awspring.cloud.sqs.operations.SqsTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class Sender {
    @Autowired
    private SqsTemplate sqsTemplate;
    public void sendMessage(){
        System.out.println("sending message to sqs");
        SendResult<String> result = sqsTemplate.send(to -> to
                .payload("this is my second message, Hurrah !!!")
                .header("myHeaderName", "myHeaderValue")
                .headers(java.util.Map.of("myOtherHeaderName", "myOtherHeaderValue"))
                .delaySeconds(1)
        );

        System.out.println("message sent successfully ");
    }
}
