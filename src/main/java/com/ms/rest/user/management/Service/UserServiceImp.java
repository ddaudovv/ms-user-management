package com.ms.rest.user.management.Service;

import com.ms.rest.user.management.DTO.UserRequestDTO;
import com.ms.rest.user.management.DTO.UserResponseDTO;
import com.ms.rest.user.management.Entity.UserEntity;
import com.ms.rest.user.management.Mapper.UserMapper;
import com.ms.rest.user.management.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        UserEntity savedUser = userMapper.toRequestDTO(userRequest);

        userRepository.save(savedUser);

        return userMapper.toResponseDTO(savedUser);
    }


    @Override
    public Optional<UserResponseDTO> getUserById(Integer id) {
        if (id <= 0) return Optional.empty();

        Optional<UserEntity> getUser = userRepository.findById(id);

        if (getUser.isPresent()) {
            return getUser.map(userMapper::toResponseDTO);
        }

        return Optional.empty();
    }

    @Override
    public List<UserResponseDTO> getAllUser() {
        List<UserEntity> listOfAllUsers = userRepository.findAll();

        return userMapper.listOfUserToResponseDTO(listOfAllUsers);
    }


    @Override
    public Optional<UserResponseDTO> updateUser(Integer id, UserRequestDTO user) {
        Optional<UserEntity> userToUpdate = userRepository.findById(id);

        if (userToUpdate.isPresent()) {
            UserEntity updatedUser = userToUpdate.get();

            updatedUser.setFirstName(user.getFirstName());
            updatedUser.setLastName(user.getLastName());
            updatedUser.setDateOfBirth(user.getDateOfBirth());
            updatedUser.setPhoneNumber(user.getPhoneNumber());
            updatedUser.setEmailAddress(user.getEmailAddress());

            UserEntity savedUser = userRepository.save(updatedUser);

            return Optional.of(userMapper.toResponseDTO(savedUser));
        }

        return Optional.empty();
    }


    @Override
    public Optional<UserResponseDTO> deleteUser(Integer id) {
        Optional<UserEntity> userToDelete = userRepository.findById(id);

        if (userToDelete.isPresent()) {
            userRepository.deleteById(id);

            return Optional.of(userMapper.toResponseDTO(userToDelete.get()));
        }

        return Optional.empty();
    }
}
