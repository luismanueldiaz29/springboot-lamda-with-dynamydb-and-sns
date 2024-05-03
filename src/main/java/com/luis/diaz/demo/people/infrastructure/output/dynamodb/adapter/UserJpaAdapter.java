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
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
public class UserJpaAdapter implements IUserPersistencePort {
    private final DynamoDBMapper dynamoDBMapper;
    private final IUserEntityMapper userEntityMapper;

    @Override
    public List<User> getAllUser() {
        return dynamoDBMapper.scan(UserEntity.class, new DynamoDBScanExpression()).stream().map(userEntityMapper::toUser).toList();
    }

    @Override
    public User getUser(String id) {
        return userEntityMapper.toUser(dynamoDBMapper.load(UserEntity.class, id));
    }

    @Override
    public User saveUser(User user) {
        UserEntity userEntity = userEntityMapper.toUserEntity(user);
        dynamoDBMapper.save(userEntity);
        return userEntityMapper.toUser(userEntity);
    }

    @Override
    public User updateUser(User user) {
        UserEntity userEntity = userEntityMapper.toUserEntity(user);
        dynamoDBMapper.save(userEntity, new DynamoDBSaveExpression().withExpectedEntry("id",
                new ExpectedAttributeValue(new AttributeValue().withS(userEntity.getId()))));
        return userEntityMapper.toUser(userEntity);
    }

    @Override
    public void deleteUser(String id) {
        User user=null;
        Map<String, AttributeValue> eav= new HashMap<String ,AttributeValue>();
        eav.put(":id", new AttributeValue().withS(id));

        DynamoDBScanExpression scanExpression=new DynamoDBScanExpression()
                .withFilterExpression("dni = :dni")
                .withExpressionAttributeValues(eav);

        List<User> useResult=dynamoDBMapper.scan(User.class, scanExpression);
        if(!useResult.isEmpty() && useResult.size()>0) {
            user=useResult.get(0);
        }
        dynamoDBMapper.delete(user);
    }
}
