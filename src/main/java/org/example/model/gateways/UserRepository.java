package org.example.model.gateways;

import org.example.model.User;
import reactor.core.publisher.Mono;

public interface UserRepository {
    Mono<User> saveUser(User user);
}
