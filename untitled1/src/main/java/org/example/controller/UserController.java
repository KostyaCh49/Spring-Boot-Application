package org.example.controller;

import org.example.model.User;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public void create(@RequestBody User user) {
        userService.create(user);
    }

    @GetMapping("/get/{id}")
    public User getById(@PathVariable Long id) {
        return userService.getById(id);
    }

    @GetMapping("/get")
    public List<User> getAll() {
        return userService.getAll();
    }

    @PutMapping("/update/{id}")
    public User update(@PathVariable Long id, @RequestBody User user) {
        return userService.update(id, user);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }
}
