package com.luis.diaz.demo.people.application.handler;

public interface IEmailHandler {
    Boolean publishMessage(String email);
    void subscribeToSNSTopic(String message);
}
