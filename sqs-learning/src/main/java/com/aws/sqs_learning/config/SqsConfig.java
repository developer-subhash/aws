package com.aws.sqs_learning.config;

import io.awspring.cloud.sqs.operations.SqsTemplate;
import io.awspring.cloud.sqs.operations.TemplateAcknowledgementMode;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.services.sqs.SqsAsyncClient;

@Configuration
public class SqsConfig {
    @Value("${aws.queue.name}")
    private String queueName;

    // create async sqs client
    // used to send as well as receive
    @Bean
    public SqsTemplate sqsTemplate(SqsAsyncClient sqsAsyncClient){
        SqsTemplate sqsTemplate = SqsTemplate.builder()
                .sqsAsyncClient(sqsAsyncClient)
                .configure(sqsTemplateOptions -> sqsTemplateOptions
                        .acknowledgementMode(TemplateAcknowledgementMode.MANUAL)
                        .defaultQueue(queueName))
                .build();

        return sqsTemplate;
    }

    @Bean
    public SqsAsyncClient sqsAsyncClient(){
        return SqsAsyncClient.builder().build();
    }
}
