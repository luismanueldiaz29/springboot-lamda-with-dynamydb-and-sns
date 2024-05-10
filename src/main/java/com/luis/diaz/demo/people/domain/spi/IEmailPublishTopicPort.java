package com.luis.diaz.demo.people.domain.spi;

public interface IEmailPublishTopicPort {
    Boolean publishMessageToTopic(String subject, String message);
    void addSubscription(String email);
}
