package com.luis.diaz.demo.people.application.mapper;

import com.luis.diaz.demo.people.application.dto.request.UserRequest;
import com.luis.diaz.demo.people.application.dto.response.UserResponse;
import com.luis.diaz.demo.people.domain.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserDtoMapper implements IUserDtoMapper {

    @Override
    public User toUser(UserRequest userRequest) {
        if (userRequest == null) return null;
        User user = new User();
        user.setName(userRequest.getName());
        user.setIdentification(userRequest.getIdentification());
        return user;
    }

    @Override
    public UserResponse toUserDto(User user) {
        if (user == null) return null;
        UserResponse userResponse = new UserResponse();
        userResponse.setId(user.getId());
        userResponse.setName(user.getName());
        userResponse.setIdentification(user.getIdentification());
        return userResponse;
    }
}
