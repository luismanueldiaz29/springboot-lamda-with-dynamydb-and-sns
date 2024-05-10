package com.luis.diaz.demo.people.domain.spi;

public interface IEmailPublishTopicPort {
    Boolean publishMessageToTopic(String message);
    void addSubscription(String email);
}
