package org.example.entity;

import org.reactivecommons.utils.ObjectMapper;
import org.example.entity.helper.TemplateAdapterOperations;
import org.example.model.User;
import org.springframework.stereotype.Repository;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedAsyncClient;

@Repository
public class DynamoDBTemplateAdapter extends TemplateAdapterOperations<User, String, UserEntity> {
    public DynamoDBTemplateAdapter(DynamoDbEnhancedAsyncClient connectionFactory, ObjectMapper mapper) {
        super(connectionFactory, mapper, d -> mapper.map(d, User.class), "nu7010001-fraud-alert-centralizer-dev-alertMaster");
    }
}

