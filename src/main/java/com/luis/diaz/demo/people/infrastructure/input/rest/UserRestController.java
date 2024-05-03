package com.luis.diaz.demo.people.infrastructure.input.rest;


import com.luis.diaz.demo.people.application.dto.request.UserRequest;
import com.luis.diaz.demo.people.application.dto.response.UserResponse;
import com.luis.diaz.demo.people.application.handler.IUserHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserRestController {
    private final IUserHandler userHandler;

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody UserRequest userRequest){
        userHandler.saveUser(userRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @GetMapping
    public ResponseEntity<List<UserResponse>> getAll(){
        return ResponseEntity.ok(userHandler.getAllUser());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserByNumber(@PathVariable String id){
        return ResponseEntity.ok(userHandler.getUser(id));
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody UserRequest userRequest){
        userHandler.saveUser(userRequest);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        userHandler.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
