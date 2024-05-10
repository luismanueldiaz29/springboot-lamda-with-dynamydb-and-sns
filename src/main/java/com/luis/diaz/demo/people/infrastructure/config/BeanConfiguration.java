package com.luis.diaz.demo.people.infrastructure.config;

import com.amazonaws.services.sns.AmazonSNSClient;
import com.luis.diaz.demo.people.domain.api.IEmailServicePort;
import com.luis.diaz.demo.people.domain.api.IUserServicePort;
import com.luis.diaz.demo.people.domain.spi.IEmailPublishTopicPort;
import com.luis.diaz.demo.people.domain.spi.IUserPersistencePort;
import com.luis.diaz.demo.people.domain.usercase.EmailUseCase;
import com.luis.diaz.demo.people.domain.usercase.UserUseCase;
import com.luis.diaz.demo.people.infrastructure.output.dynamodb.adapter.UserJpaAdapter;
import com.luis.diaz.demo.people.infrastructure.output.dynamodb.mapper.IUserEntityMapper;
import com.luis.diaz.demo.people.infrastructure.output.dynamodb.repository.IUserRepository;
import com.luis.diaz.demo.people.infrastructure.output.sns.adapter.EmailPublishAmazonSnsAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private final IUserRepository userRepository;
    private final IUserEntityMapper userEntityMapper;
    private final AmazonSNSClient amazonSNSClient;

    @Bean
    public IUserPersistencePort userPersistencePort(){
        return new UserJpaAdapter(userRepository, userEntityMapper);

    }

    @Bean
    public IUserServicePort userServicePort(){
        return new UserUseCase(userPersistencePort());
    }

    @Bean
    public IEmailPublishTopicPort emailPublishTopicPort(){
        return new EmailPublishAmazonSnsAdapter(amazonSNSClient);
    }

    @Bean
    public IEmailServicePort emailServicePort(){
        return new EmailUseCase(emailPublishTopicPort());
    }
}
