package com.luis.diaz.demo.people.domain.usercase;

import com.luis.diaz.demo.people.domain.api.IUserServicePort;
import com.luis.diaz.demo.people.domain.model.User;
import com.luis.diaz.demo.people.domain.spi.IUserPersistencePort;

import java.util.List;

public class UserUseCase implements IUserServicePort {
    private final IUserPersistencePort userPersistencePort;

    public UserUseCase(IUserPersistencePort userPersistencePort) {
        this.userPersistencePort = userPersistencePort;
    }

    @Override
    public List<User> getAllUser() {
        return userPersistencePort.getAllUser();
    }

    @Override
    public User getUser(String id) {
        return userPersistencePort.getUser(id);
    }

    @Override
    public User saveUser(User user) {
        return userPersistencePort.saveUser(user);
    }

    @Override
    public User updateUser(User user) {
        return userPersistencePort.updateUser(user);
    }

    @Override
    public void deleteUser(String id) {
        userPersistencePort.deleteUser(id);
    }
}
