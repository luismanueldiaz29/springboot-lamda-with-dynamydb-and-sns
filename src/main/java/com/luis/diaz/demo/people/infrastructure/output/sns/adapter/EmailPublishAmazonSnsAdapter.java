package com.luis.diaz.demo.people.infrastructure.output.sns.adapter;

import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.SubscribeRequest;
import com.luis.diaz.demo.people.domain.spi.IEmailPublishTopicPort;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

@RequiredArgsConstructor
public class EmailPublishAmazonSnsAdapter implements IEmailPublishTopicPort {
    private final AmazonSNSClient amazonSNSClient;

    @Value("${amazon.aws.sns.topic}")
    private String TOPIC_ARN;

    @Override
    public Boolean publishMessageToTopic(String message) {
        try {
            PublishRequest publishRequest = new PublishRequest(TOPIC_ARN, "SNS message", message);
            amazonSNSClient.publish(publishRequest);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public void addSubscription(String email) {
        SubscribeRequest subscribeRequest = new SubscribeRequest(TOPIC_ARN,"email", email);
        System.out.println(subscribeRequest.getTopicArn());
        amazonSNSClient.subscribe(subscribeRequest);
    }
}
