package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;

@Data
@AllArgsConstructor
@NoArgsConstructor
@DynamoDbBean
public class ChannelEntity {
    private String num;
    private String code;
}