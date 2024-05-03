package com.luis.diaz.demo.people.infrastructure.output.dynamodb.repository;

import com.luis.diaz.demo.people.infrastructure.output.dynamodb.entity.UserEntity;

import java.util.List;

public interface IUserRepository {
    List<UserEntity> findAll();
    UserEntity findById(String id);
    void save(UserEntity user);
    void update(UserEntity user);
    void deleteById(String id);
}
