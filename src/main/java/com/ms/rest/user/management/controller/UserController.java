package com.ms.rest.user.management.controller;

import com.ms.rest.user.management.dto.UserRequestDTO;
import com.ms.rest.user.management.dto.UserResponseDTO;
import com.ms.rest.user.management.service.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private final UserServiceImp userService;


    public UserController(UserServiceImp userService) {
        this.userService = userService;
    }


    @PostMapping("/create")
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody UserRequestDTO userRequest) {
        UserResponseDTO createdUser = userService.createUser(userRequest);

        //return ResponseEntity.ok(createdUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }


    @GetMapping("/{userId}")
    public ResponseEntity<UserResponseDTO> getUser(@PathVariable Integer userId) {
        UserResponseDTO responseUser = userService.getUserById(userId);
        return ResponseEntity.ok(responseUser);
    }


    @GetMapping("/all")
    public ResponseEntity<List<UserResponseDTO>> getAllUsers() {
        List<UserResponseDTO> users = userService.getAllUser();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/search")
    public ResponseEntity<List<UserResponseDTO>> searchUsers(@RequestParam String term) {
        List<UserResponseDTO> users = userService.searchUsers(term);
        return ResponseEntity.ok(users);
    }

    @PutMapping("/update/{userId}")
    public ResponseEntity<UserResponseDTO> updateUser(@PathVariable Integer userId, @RequestBody UserRequestDTO newUser) {
        UserResponseDTO updatedUser = userService.updateUser(userId, newUser);
        return ResponseEntity.ok(updatedUser);
    }


    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<UserResponseDTO> deleteUser(@PathVariable Integer userId) {
        UserResponseDTO deletedUser = userService.deleteUser(userId);
        return ResponseEntity.ok(deletedUser);
    }
}
