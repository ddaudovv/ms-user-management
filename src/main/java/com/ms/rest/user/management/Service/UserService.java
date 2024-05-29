package com.ms.rest.user.management.Service;


import com.ms.rest.user.management.DTO.UserRequestDTO;
import com.ms.rest.user.management.DTO.UserResponseDTO;
import com.ms.rest.user.management.Entity.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {
    UserResponseDTO createUser(UserRequestDTO user);

    Optional<UserResponseDTO> getUserById(Integer id);

    List<UserResponseDTO> getAllUser();

    Optional<UserResponseDTO> updateUser(Integer id, UserRequestDTO user);

    Optional<UserResponseDTO> deleteUser(Integer id);
}
