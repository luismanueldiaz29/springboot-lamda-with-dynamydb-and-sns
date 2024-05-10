package com.luis.diaz.demo.people.application.dto.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class EmailRequest {
    private String subject;
    private String body;
}
