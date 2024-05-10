package com.luis.diaz.demo.people.application.handler;

public interface IEmailHandler {
    Boolean publishMessage(String message, String s);
    void subscribeToSNSTopic(String message);
}
