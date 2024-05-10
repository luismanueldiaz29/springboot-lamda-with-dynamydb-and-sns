package com.luis.diaz.demo.people.infrastructure.input.rest;

import com.luis.diaz.demo.people.application.handler.EmailHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/publish")
    public ResponseEntity<String> publishToTopic(
            @RequestParam String subject,
            @RequestParam String message
    ){
        emailHandler.publishMessage(subject, message);
        return ResponseEntity.ok("Message Published!");
    }
}
