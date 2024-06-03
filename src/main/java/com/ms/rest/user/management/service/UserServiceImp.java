package com.ms.rest.user.management.service;

import com.ms.rest.user.management.dto.UserRequestDTO;
import com.ms.rest.user.management.dto.UserResponseDTO;
import com.ms.rest.user.management.entity.UserEntity;
import com.ms.rest.user.management.exception.UserNotFoundException;
import com.ms.rest.user.management.mapper.UserMapper;
import com.ms.rest.user.management.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserServiceImp(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }


    @Override
    public UserResponseDTO createUser(UserRequestDTO userRequest) {
        UserEntity userEntity = userMapper.toRequestDTO(userRequest);

        userRepository.save(userEntity);

        return userMapper.toResponseDTO(userEntity);
    }


    @Override
    public UserResponseDTO getUserById(Integer id) {
        // If id is not in range, throw exception.
        if (id <= 0) throw new IllegalArgumentException("Invalid User ID: " + id);

        UserEntity userEntity = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found with ID: " + id));

        return userMapper.toResponseDTO(userEntity);
    }

    @Override
    public List<UserResponseDTO> getAllUser() {
        // Fetch all users and sort them by lastName and dateOfBirth.
        Sort sort = Sort.by(Sort.Order.asc("lastName"), Sort.Order.asc("dateOfBirth"));

        List<UserEntity> listOfAllUsers = userRepository.findAll(sort);

        return userMapper.listOfUserToResponseDTO(listOfAllUsers);
    }

    @Override
    public List<UserResponseDTO> searchUsers(String searchTerm) {
        if (searchTerm.isEmpty()) {
            throw new IllegalArgumentException("Search term cannot be empty.");
        }

        // Search for users whose first name, last name, or email address contains the given search term..
        List<UserEntity> foundUsers = userRepository.findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCaseOrEmailAddressContainingIgnoreCase(searchTerm, searchTerm, searchTerm);

        if (foundUsers.isEmpty()) throw new UserNotFoundException("No users found matching the search term: " + searchTerm);

        return userMapper.listOfUserToResponseDTO(foundUsers);
    }


    @Override
    public UserResponseDTO updateUser(Integer id, UserRequestDTO user) {
        // If id is not in range, throw exception.
        if (id <= 0) throw new IllegalArgumentException("Invalid User ID: " + id);

        UserEntity userToUpdate = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found with ID: " + id));

        userToUpdate.setId(id);
        userToUpdate.setFirstName(user.getFirstName());
        userToUpdate.setLastName(user.getLastName());
        userToUpdate.setDateOfBirth(user.getDateOfBirth());
        userToUpdate.setPhoneNumber(user.getPhoneNumber());
        userToUpdate.setEmailAddress(user.getEmailAddress());

        UserEntity savedUser = userRepository.save(userToUpdate);

        return userMapper.toResponseDTO(savedUser);
    }


    @Override
    public UserResponseDTO deleteUser(Integer id) {
        // If id is not in range, throw exception.
        if (id <= 0) throw new IllegalArgumentException("Invalid User ID: " + id);

        UserEntity userToDelete = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found with ID: " + id));

        userRepository.deleteById(id);

        return userMapper.toResponseDTO(userToDelete);
    }
}
