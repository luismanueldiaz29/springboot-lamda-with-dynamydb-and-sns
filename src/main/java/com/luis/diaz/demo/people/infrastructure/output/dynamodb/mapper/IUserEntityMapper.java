package com.luis.diaz.demo.people.infrastructure.output.dynamodb.mapper;

import com.luis.diaz.demo.people.domain.model.User;
import com.luis.diaz.demo.people.infrastructure.output.dynamodb.entity.UserEntity;

public interface IUserEntityMapper {
    User toUser(UserEntity userEntity);
    UserEntity toUserEntity(User user);
}
