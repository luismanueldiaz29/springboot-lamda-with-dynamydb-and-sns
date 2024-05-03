package com.luis.diaz.demo.people.infrastructure.output.dynamodb.mapper;

import com.luis.diaz.demo.people.domain.model.User;
import com.luis.diaz.demo.people.infrastructure.output.dynamodb.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserEntityMapper implements IUserEntityMapper {
    @Override
    public User toUser(UserEntity userEntity) {
        if (userEntity == null) return null;

        User user = new User();
        user.setId(userEntity.getId());
        user.setName(userEntity.getName());
        user.setIdentification(userEntity.getIdentification());
        return user;
    }

    @Override
    public UserEntity toUserEntity(User user) {
        if (user == null) return null;

        UserEntity userEntity = new UserEntity();
        userEntity.setId(user.getId());
        userEntity.setName(user.getName());
        userEntity.setIdentification(user.getIdentification());
        return userEntity;
    }
}
