package com.ms.rest.user.management.service;


import com.ms.rest.user.management.dto.UserRequestDTO;
import com.ms.rest.user.management.dto.UserResponseDTO;

import java.util.List;
import java.util.Optional;

public interface UserService {
    UserResponseDTO createUser(UserRequestDTO user);

    Optional<UserResponseDTO> getUserById(Integer id);

    List<UserResponseDTO> getAllUser();

    Optional<UserResponseDTO> updateUser(Integer id, UserRequestDTO user);

    Optional<UserResponseDTO> deleteUser(Integer id);
}
