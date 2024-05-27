package com.ms.rest.user.management.Service;


import com.ms.rest.user.management.Entity.UserEntity;

import java.util.Optional;

public interface UserService {
    public UserEntity createUser(UserEntity user);
    public Optional<UserEntity> getUserById(Integer user);
}
