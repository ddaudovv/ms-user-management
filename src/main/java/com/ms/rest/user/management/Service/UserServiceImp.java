package com.ms.rest.user.management.Service;

import com.ms.rest.user.management.Entity.UserEntity;
import com.ms.rest.user.management.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    private final UserRepository userRepository;

    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserEntity createUser(UserEntity user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<UserEntity> getUserById(Integer id) {
        return userRepository.findById(id);
    }
}
