package com.ms.rest.user.management.service;


import com.ms.rest.user.management.dto.UserRequestDTO;
import com.ms.rest.user.management.dto.UserResponseDTO;

import java.util.List;
import java.util.Optional;

public interface UserService {
    UserResponseDTO createUser(UserRequestDTO user);

    UserResponseDTO getUserById(Integer id);

    List<UserResponseDTO> getAllUser();

    List<UserResponseDTO> searchUsers(String searchTerm);

    UserResponseDTO updateUser(Integer id, UserRequestDTO user);

    UserResponseDTO deleteUser(Integer id);
}
