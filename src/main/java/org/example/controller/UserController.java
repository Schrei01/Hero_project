package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Mono;

import org.example.model.User;
import org.example.service.UserService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;


    @PostMapping
    public Mono<ResponseEntity<String>> createUser(@RequestBody User user) {

        return userService.saveUser(user)
                .then(Mono.just(ResponseEntity.status(HttpStatus.CREATED).body("Usuario guardado con éxito"))
                .onErrorResume(e -> Mono.just(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al guardar el usuario: " + e.getMessage()))));
    }
}
