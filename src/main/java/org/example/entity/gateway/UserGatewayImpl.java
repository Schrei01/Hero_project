package org.example.entity.gateway;

import lombok.RequiredArgsConstructor;
import org.example.entity.DynamoDBTemplateAdapter;
import org.example.model.User;
import org.example.model.gateways.UserRepository;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class UserGatewayImpl implements UserRepository {

    private final DynamoDBTemplateAdapter dynamoDBTemplateAdapter;

    @Override
    public Mono<User> saveUser(User user) {
        return Mono.fromRunnable(() -> dynamoDBTemplateAdapter.save(user));
    }
}
