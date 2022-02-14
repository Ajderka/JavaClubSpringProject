package com.group4.service.interfaces;

import com.group4.model.Book;
import com.group4.model.User;

import java.util.List;

public interface UserService {
    void addUser(User user);

    void updateUser(User user);

    void removeUser(int id);

    User getUserById(int id);

    List<User> listUser();

    void saveUser(User user);

    User deleteById(int id);


}
