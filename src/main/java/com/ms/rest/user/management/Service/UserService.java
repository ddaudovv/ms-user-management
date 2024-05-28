package com.ms.rest.user.management.Service;


import com.ms.rest.user.management.Entity.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {
    public UserEntity createUser(UserEntity user);

    Optional<UserEntity> getUserById(Integer id);

    List<UserEntity> getAllUser();

    Optional<UserEntity> updateUser(Integer id, UserEntity user);

    Optional<UserEntity> deleteUser(Integer id);
}
