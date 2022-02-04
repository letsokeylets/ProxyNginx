package ru.netology.serviceautorizate.controller;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.netology.serviceautorizate.advice.InvalidCredentials;
import ru.netology.serviceautorizate.advice.UnauthorizedUser;
import ru.netology.serviceautorizate.service.AuthorizationService;

import java.util.List;

@RestController
public class AuthorizationController {
    private final AuthorizationService service;

    public AuthorizationController(AuthorizationService service) {
        this.service = service;
    }

    @Value("${instance.num:0}")
    private int instance;

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@RequestParam("user") String user, @RequestParam("password") String password) {
        return service.getAuthorities(user, password);
    }

    @GetMapping("/")
    public String hello() {
        return "Hello from instance: " + instance;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidCredentials.class)
    public String invalidCredentialsHandle(InvalidCredentials e) {
        return e.getMessage();
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(UnauthorizedUser.class)
    public String unauthorizedUserHandle(UnauthorizedUser e) {
        return e.getMessage();
    }
}
