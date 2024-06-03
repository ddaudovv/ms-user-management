package com.ms.rest.user.management.controller;

import com.ms.rest.user.management.dto.UserRequestDTO;
import com.ms.rest.user.management.dto.UserResponseDTO;
import com.ms.rest.user.management.service.UserServiceImp;
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
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody UserRequestDTO userRequest) {
        UserResponseDTO createdUser = userService.createUser(userRequest);

        //return ResponseEntity.ok(createdUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }


    @GetMapping("/{userId}")
    public ResponseEntity<Optional<UserResponseDTO>> getUser(@PathVariable Integer userId) {
        try {
            Optional<UserResponseDTO> responseUser = userService.getUserById(userId);

            if (responseUser.isPresent()) {
                return ResponseEntity.ok(responseUser);
            }

            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @GetMapping("/all")
    public ResponseEntity<List<UserResponseDTO>> getAllUsers() {
        List<UserResponseDTO> users = userService.getAllUser();
        return ResponseEntity.ok(users);
    }


    @PutMapping("/update/{userId}")
    public ResponseEntity<Optional<UserResponseDTO>> updateUser(@PathVariable Integer userId, @RequestBody UserRequestDTO newUser) {
        Optional<UserResponseDTO> updatedUser = userService.updateUser(userId, newUser);

        if (updatedUser.isPresent()) {
            return ResponseEntity.ok(updatedUser);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }


    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<Optional<UserResponseDTO>> deleteUser(@PathVariable Integer userId) {
        try {
            Optional<UserResponseDTO> deletedUser = userService.deleteUser(userId);

            if (deletedUser.isPresent()) {
                return ResponseEntity.ok(deletedUser);
            }

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Optional.empty());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Optional.empty());
        }
    }
}
