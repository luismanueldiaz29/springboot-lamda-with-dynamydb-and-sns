package com.luis.diaz.demo.people.domain.spi;


import com.luis.diaz.demo.people.domain.model.User;

import java.util.List;

public interface IUserPersistencePort {
    List<User> getAllUser();
    User getUser(String id);
    User saveUser(User user);
    User updateUser(User user);
    void deleteUser(String id);
}
