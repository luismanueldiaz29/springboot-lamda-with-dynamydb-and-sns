package com.luis.diaz.demo.people.infrastructure.output.dynamodb.adapter;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.luis.diaz.demo.people.domain.model.User;
import com.luis.diaz.demo.people.domain.spi.IUserPersistencePort;
import com.luis.diaz.demo.people.infrastructure.output.dynamodb.entity.UserEntity;
import com.luis.diaz.demo.people.infrastructure.output.dynamodb.mapper.IUserEntityMapper;
import com.luis.diaz.demo.people.infrastructure.output.dynamodb.repository.IUserRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;


@RequiredArgsConstructor
public class UserJpaAdapter implements IUserPersistencePort {
    private final IUserRepository userRepository;
    private final IUserEntityMapper userEntityMapper;

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll().stream().map(userEntityMapper::toUser).toList();
    }

    @Override
    public User getUser(String id) {
        return userEntityMapper.toUser(userRepository.findById(id));
    }

    @Override
    public User saveUser(User user) {
        UserEntity userEntity = userEntityMapper.toUserEntity(user);
        userRepository.save(userEntity);
        return userEntityMapper.toUser(userEntity);
    }

    @Override
    public User updateUser(User user) {
        UserEntity userEntity = userEntityMapper.toUserEntity(user);
        userRepository.update(userEntity);
        return userEntityMapper.toUser(userEntity);
    }

    @Override
    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }
}
