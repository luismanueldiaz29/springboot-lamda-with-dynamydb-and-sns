package com.luis.diaz.demo.people.application.mapper;

import com.luis.diaz.demo.people.application.dto.request.UserRequest;
import com.luis.diaz.demo.people.application.dto.response.UserResponse;
import com.luis.diaz.demo.people.domain.model.User;

public interface IUserDtoMapper {
    User toUser(UserRequest userRequest);
    UserResponse toUserDto(User user);
}
