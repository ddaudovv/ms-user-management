package com.ms.rest.user.management.mapper;


import com.ms.rest.user.management.dto.UserRequestDTO;
import com.ms.rest.user.management.dto.UserResponseDTO;
import com.ms.rest.user.management.entity.UserEntity;

import java.util.List;

public interface UserMapper {
    UserResponseDTO toResponseDTO (UserEntity user);

    UserEntity toRequestDTO (UserRequestDTO user);

    List<UserResponseDTO> listOfUserToResponseDTO (List<UserEntity> users);
}
