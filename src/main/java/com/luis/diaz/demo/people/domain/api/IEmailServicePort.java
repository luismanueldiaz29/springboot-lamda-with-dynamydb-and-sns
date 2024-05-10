package com.luis.diaz.demo.people.domain.api;

public interface IEmailServicePort {
    Boolean publishMessage(String message);
    void subscribeToSNSTopic(String email);
}
