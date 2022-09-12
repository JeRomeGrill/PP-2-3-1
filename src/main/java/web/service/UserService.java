package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    User add(User user);
    List<User> listUsers();
    void changeUser (User user);
    void removeUser (User user);
}
