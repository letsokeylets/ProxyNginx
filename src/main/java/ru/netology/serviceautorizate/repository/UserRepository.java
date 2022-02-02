package ru.netology.serviceautorizate.repository;

import org.springframework.stereotype.Repository;
import ru.netology.serviceautorizate.controller.Authorities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static ru.netology.serviceautorizate.controller.Authorities.DELETE;
import static ru.netology.serviceautorizate.controller.Authorities.READ;
import static ru.netology.serviceautorizate.controller.Authorities.WRITE;

@Repository
public class UserRepository {

    private static final String USER = "admin";
    private static final String PASSWORD = "1234";

    public List<Authorities> getUserAuthorities(String user, String password) {
        if (user.equals(USER) && password.equals(PASSWORD))
            return Arrays.asList(READ, WRITE, DELETE);
        return new ArrayList<>();
    }
}
