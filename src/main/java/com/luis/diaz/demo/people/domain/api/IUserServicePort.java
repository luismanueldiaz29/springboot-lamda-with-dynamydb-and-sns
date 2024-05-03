package com.luis.diaz.demo.people.domain.api;

import com.luis.diaz.demo.people.domain.model.User;

import java.util.List;

public interface IUserServicePort {
    List<User> getAllUser();
    User getUser(String id);
    User saveUser(User user);
    User updateUser(User user);
    void deleteUser(String id);
}
