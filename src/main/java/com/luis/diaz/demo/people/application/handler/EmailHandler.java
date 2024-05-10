package com.luis.diaz.demo.people.application.handler;

import com.luis.diaz.demo.people.domain.api.IEmailServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailHandler implements IEmailHandler{
    private final IEmailServicePort emailServicePort;

    @Override
    public Boolean publishMessage(String message) {
        return emailServicePort.publishMessage(message);
    }

    @Override
    public void subscribeToSNSTopic(String email) {
        emailServicePort.subscribeToSNSTopic(email);
    }
}
