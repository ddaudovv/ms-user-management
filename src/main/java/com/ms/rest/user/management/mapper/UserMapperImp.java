package com.ms.rest.user.management.mapper;

import com.ms.rest.user.management.dto.UserRequestDTO;
import com.ms.rest.user.management.dto.UserResponseDTO;
import com.ms.rest.user.management.entity.UserEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserMapperImp implements UserMapper {
    @Override
    public UserResponseDTO toResponseDTO(UserEntity user) {
        UserResponseDTO response = new UserResponseDTO();

        response.setId(user.getId());
        response.setFirstName(user.getFirstName());
        response.setLastName(user.getLastName());
        response.setDateOfBirth(user.getDateOfBirth());
        response.setPhoneNumber(user.getPhoneNumber());
        response.setEmailAddress(user.getEmailAddress());

        return response;
    }


    @Override
    public UserEntity toRequestDTO(UserRequestDTO request) {
        UserEntity user = new UserEntity();

        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setDateOfBirth(request.getDateOfBirth());
        user.setPhoneNumber(request.getPhoneNumber());
        user.setEmailAddress(request.getEmailAddress());

        return user;
    }


    @Override
    public List<UserResponseDTO> listOfUserToResponseDTO(List<UserEntity> users) {
        List<UserResponseDTO> responseListOfAllUsers = new ArrayList<>();

        for (UserEntity user : users) {
            UserResponseDTO response = toResponseDTO(user);
            responseListOfAllUsers.add(response);
        }

        return responseListOfAllUsers;
    }
}
