package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

@Data
@AllArgsConstructor
@NoArgsConstructor
@DynamoDbBean
public class UserEntity {

    private String sessionId;
    private String name;
    private String email;
    private ChannelEntity channel;

    @DynamoDbPartitionKey
    public String getSessionId() {
        return sessionId;
    }
}


