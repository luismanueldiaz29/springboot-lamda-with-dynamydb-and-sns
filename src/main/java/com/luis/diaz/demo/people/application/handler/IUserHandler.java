package com.luis.diaz.demo.people.application.handler;

import com.luis.diaz.demo.people.application.dto.request.UserRequest;
import com.luis.diaz.demo.people.application.dto.response.UserResponse;

import java.util.List;

public interface IUserHandler {
    List<UserResponse> getAllUser();
    UserResponse getUser(String id);
    UserResponse saveUser(UserRequest userRequest);
    UserResponse updateUser(String id, UserRequest userRequest);
    void deleteUser(String id);
}
