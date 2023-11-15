package org.example.service;

import org.example.model.User;

import java.util.List;

public interface UserService {
    void create(User user);
    User getById(Long id);
    List<User> getAll();
    User update(Long id, User user);
    void delete(Long id);
}
