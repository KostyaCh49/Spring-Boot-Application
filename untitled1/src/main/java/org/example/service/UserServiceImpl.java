package org.example.service;

import org.example.model.User;
import org.example.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void create(User user) {
        userRepository.save(user);
    }

    @Override
    public User getById(Long id) {
        return userRepository.getUserById(id);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User update(Long id, User incomingUser) {
        User user = getById(id);

        if (incomingUser.getUsername() == null || incomingUser.getPassword() == null) {
            throw new RuntimeException("Username and password must be filed");
        }

        user.setUsername(incomingUser.getUsername());
        user.setPassword(incomingUser.getPassword());

        return userRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        User user = getById(id);
        userRepository.delete(user);
    }
}
