package com.luis.diaz.demo.people.application.handler;

import com.luis.diaz.demo.people.application.dto.request.UserRequest;
import com.luis.diaz.demo.people.application.dto.response.UserResponse;
import com.luis.diaz.demo.people.application.mapper.IUserDtoMapper;
import com.luis.diaz.demo.people.domain.api.IUserServicePort;
import com.luis.diaz.demo.people.domain.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserHandler implements IUserHandler {
    private final IUserServicePort userServicePort;
    private final IUserDtoMapper userDtoMapper;

    @Override
    public List<UserResponse> getAllUser() {
        return userServicePort.getAllUser().stream().map(userDtoMapper::toUserDto).toList();
    }

    @Override
    public UserResponse getUser(String id) {
        return userDtoMapper.toUserDto(userServicePort.getUser(id));
    }

    @Override
    public UserResponse saveUser(UserRequest userRequest) {
        return userDtoMapper.toUserDto(userServicePort.saveUser(userDtoMapper.toUser(userRequest)));
    }

    @Override
    public UserResponse updateUser(String id, UserRequest userRequest) {
        User user = userDtoMapper.toUser(userRequest);
        user.setId(id);
        return userDtoMapper.toUserDto(userServicePort.updateUser(user));
    }

    @Override
    public void deleteUser(String id) {
        userServicePort.deleteUser(id);
    }
}
