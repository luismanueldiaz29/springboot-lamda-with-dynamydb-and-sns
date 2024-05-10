package com.luis.diaz.demo.people.domain.usercase;

import com.luis.diaz.demo.people.domain.api.IEmailServicePort;
import com.luis.diaz.demo.people.domain.spi.IEmailPublishTopicPort;

public class EmailUseCase implements IEmailServicePort {
    private final IEmailPublishTopicPort emailPublishTopicPort;

    public EmailUseCase(IEmailPublishTopicPort emailPublishTopicPort) {
        this.emailPublishTopicPort = emailPublishTopicPort;
    }

    @Override
    public Boolean publishMessage(String message) {
        return emailPublishTopicPort.publishMessageToTopic(message);
    }

    @Override
    public void subscribeToSNSTopic(String email) {
        emailPublishTopicPort.addSubscription(email);
    }
}
