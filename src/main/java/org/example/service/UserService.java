package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.model.User;
import org.example.model.gateways.UserRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Mono<User> saveUser(User user){
        return userRepository.saveUser(user);
    }

}
