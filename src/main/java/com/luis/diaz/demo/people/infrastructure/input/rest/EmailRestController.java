package com.luis.diaz.demo.people.infrastructure.input.rest;

import com.luis.diaz.demo.people.application.handler.EmailHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
@RequiredArgsConstructor
public class EmailRestController {
    private final EmailHandler emailHandler;

    @GetMapping("/subscribe/{email}")
    public ResponseEntity<String> subscribeToSNSTopic(@PathVariable("email") String email) {
        emailHandler.subscribeToSNSTopic(email);
        return ResponseEntity.ok("Check your Email 🙏");
    }

    @GetMapping("/publish/{msg}")
    public ResponseEntity<String> publishToTopic(@PathVariable("msg") String message){
        emailHandler.publishMessage(message);
        return ResponseEntity.ok("Message Published!");
    }
}
