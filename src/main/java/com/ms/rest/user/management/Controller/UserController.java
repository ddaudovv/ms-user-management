package com.ms.rest.user.management.Controller;

import com.ms.rest.user.management.Entity.UserEntity;
import com.ms.rest.user.management.Service.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private final UserServiceImp userService;

    public UserController(UserServiceImp userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public UserEntity createUser(@RequestBody UserEntity user) {
        return userService.createUser(user);
    }

    @GetMapping("/{userId}")
    public Optional<UserEntity> getUser(@PathVariable int userId) {
        return userService.getUserById(userId);
    }
}
