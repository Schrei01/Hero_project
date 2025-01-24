package org.example.dynamo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedAsyncClient;
import software.amazon.awssdk.services.dynamodb.DynamoDbAsyncClient;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;

import java.net.URI;

@Configuration
public class DynamoDbConfig {

    @Bean
    @Profile({"local"})
    public DynamoDbAsyncClient dynamoDbAsyncClient(@Value("${aws.dynamodb.endpoint}") String endpoint,
                                                   @Value("${aws.region}") String region) {
        AwsBasicCredentials awsCreds = AwsBasicCredentials.create(
                "Test",   // Reemplaza con tu Access Key
                "Test" // Reemplaza con tu Secret Key
        );
        return DynamoDbAsyncClient.builder()
                .credentialsProvider(StaticCredentialsProvider.create(awsCreds))
                .region(Region.of(region))
                .endpointOverride(URI.create(endpoint))
                .build();
    }

    @Bean
    public DynamoDbEnhancedAsyncClient getDynamoDbEnhancedAsyncClient(DynamoDbAsyncClient client) {
        return DynamoDbEnhancedAsyncClient.builder()
                .dynamoDbClient(client)
                .build();
    }
}

