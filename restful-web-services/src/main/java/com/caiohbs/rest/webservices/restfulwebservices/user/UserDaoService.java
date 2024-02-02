package com.caiohbs.rest.webservices.restfulwebservices.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoService {
    private static final List<User> users = new ArrayList<>();

    private static int usersCount = 0;

    static {
        users.add(new User(++usersCount, "Erick",
                LocalDate.now().minusYears(25))
        );
        users.add(new User(++usersCount, "Jonas",
                LocalDate.now().minusYears(22))
        );
        users.add(new User(++usersCount, "Eduardo",
                LocalDate.now().minusYears(29))
        );
    }

    public List<User> findAll() {
        return users;
    }

    public User save(User user) {
        user.setId(++usersCount);
        users.add(user);
        return user;
    }

    public User findOne(int id) {
        return users.stream().filter(
                user -> user.getId().equals(id)
        ).findFirst().orElse(null);
    }
}
