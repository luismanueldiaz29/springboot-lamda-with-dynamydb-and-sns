package com.luis.diaz.demo.people.infrastructure.config;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.luis.diaz.demo.people.domain.api.IUserServicePort;
import com.luis.diaz.demo.people.domain.spi.IUserPersistencePort;
import com.luis.diaz.demo.people.domain.usercase.UserUseCase;
import com.luis.diaz.demo.people.infrastructure.output.dynamodb.adapter.UserJpaAdapter;
import com.luis.diaz.demo.people.infrastructure.output.dynamodb.mapper.IUserEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private final DynamoDBMapper userRepository;
    private final IUserEntityMapper userEntityMapper;

    @Bean
    public IUserPersistencePort userPersistencePort(){
        return new UserJpaAdapter(userRepository, userEntityMapper);
    }

    @Bean
    public IUserServicePort userServicePort(){
        return new UserUseCase(userPersistencePort());
    }
}
