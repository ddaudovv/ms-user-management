package com.ms.rest.user.management.Controller;

import com.ms.rest.user.management.Entity.UserEntity;
import com.ms.rest.user.management.Service.UserServiceImp;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
    public ResponseEntity<UserEntity> createUser(@RequestBody UserEntity user) {
        UserEntity createdUser = userService.createUser(user);
        return ResponseEntity.ok(createdUser);
    }


    @GetMapping("/{userId}")
    public ResponseEntity<Optional<UserEntity>> getUser(@PathVariable Integer userId) {
        try {
            Optional<UserEntity> responseUser = userService.getUserById(userId);

            if (responseUser.isPresent()) {
                return ResponseEntity.ok(responseUser);
            }

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Optional.empty());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Optional.empty());
        }
    }

    @GetMapping("/all")
    public List<UserEntity> getAllUsers() {
        return userService.getAllUser();
    }

    @PutMapping("/update/{userId}")
    public ResponseEntity<Optional<UserEntity>> updateUser(@PathVariable Integer userId, @RequestBody UserEntity newUser) {
        Optional<UserEntity> updatedUser = userService.updateUser(userId, newUser);

        if (updatedUser.isPresent()) {
            return ResponseEntity.ok(updatedUser);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<Optional<UserEntity>> deleteUser(@PathVariable Integer userId) {
        try {
            Optional<UserEntity> deletedUser = userService.deleteUser(userId);

            if (deletedUser.isPresent()) {
                return ResponseEntity.ok(deletedUser);
            }

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Optional.empty());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Optional.empty());
        }
    }
}
