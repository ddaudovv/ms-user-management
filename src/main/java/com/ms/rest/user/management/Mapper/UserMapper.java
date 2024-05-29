package com.ms.rest.user.management.Mapper;


import com.ms.rest.user.management.DTO.UserRequestDTO;
import com.ms.rest.user.management.DTO.UserResponseDTO;
import com.ms.rest.user.management.Entity.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserMapper {
    UserResponseDTO toResponseDTO (UserEntity user);

    UserEntity toRequestDTO (UserRequestDTO user);

    List<UserResponseDTO> listOfUserToResponseDTO (List<UserEntity> users);
}
