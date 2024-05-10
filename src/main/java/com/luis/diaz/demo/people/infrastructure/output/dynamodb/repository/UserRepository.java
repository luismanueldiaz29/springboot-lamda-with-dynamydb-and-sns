package com.luis.diaz.demo.people.infrastructure.output.dynamodb.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.luis.diaz.demo.people.domain.model.User;
import com.luis.diaz.demo.people.infrastructure.output.dynamodb.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class UserRepository implements IUserRepository{
    private final DynamoDBMapper dynamoDBMapper;

    @Override
    public List<UserEntity> findAll() {
        return dynamoDBMapper.scan(UserEntity.class, new DynamoDBScanExpression());
    }

    @Override
    public UserEntity findById(String id) {
        return dynamoDBMapper.load(UserEntity.class, id);
    }

    @Override
    public void save(UserEntity userEntity) {
        dynamoDBMapper.save(userEntity);
    }

    @Override
    public void update(UserEntity userEntity) {
        dynamoDBMapper.save(userEntity, new DynamoDBSaveExpression().withExpectedEntry("id",
                new ExpectedAttributeValue(new AttributeValue().withS(userEntity.getId()))));
    }

    @Override
    public void deleteById(String id) {
        User user=null;
        Map<String, AttributeValue> eav= new HashMap<>();
        eav.put(":id", new AttributeValue().withS(id));

        DynamoDBScanExpression scanExpression=new DynamoDBScanExpression()
                .withFilterExpression("dni = :dni")
                .withExpressionAttributeValues(eav);

        List<User> useResult=dynamoDBMapper.scan(User.class, scanExpression);
        if(!useResult.isEmpty()) {
            user=useResult.get(0);
        }
        dynamoDBMapper.delete(user);
    }
}
