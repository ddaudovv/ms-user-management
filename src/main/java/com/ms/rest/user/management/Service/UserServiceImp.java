package com.ms.rest.user.management.Service;

import com.ms.rest.user.management.Entity.UserEntity;
import com.ms.rest.user.management.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    private final UserRepository userRepository;

    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserEntity createUser(UserEntity user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<UserEntity> getUserById(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    public List<UserEntity> getAllUser() {
        return  userRepository.findAll();
    }

    @Override
    public Optional<UserEntity> updateUser(Integer id, UserEntity user) {
        Optional<UserEntity> userToUpdate = getUserById(id);

        if (userToUpdate.isPresent()) {
            UserEntity updatedUser = userToUpdate.get();

            updatedUser.setFirstName(user.getFirstName());
            updatedUser.setLastName(user.getLastName());
            updatedUser.setDateOfBirth(user.getDateOfBirth());
            updatedUser.setPhoneNumber(user.getPhoneNumber());
            updatedUser.setEmailAddress(user.getEmailAddress());
            return Optional.of(userRepository.save(updatedUser));
        }

        return Optional.empty();
    }

    @Override
    public Optional<UserEntity> deleteUser(Integer id) {
        Optional<UserEntity> userToDelete = getUserById(id);

        if (userToDelete.isPresent()) {
            userRepository.deleteById(id);
            return userToDelete;
        }

        return Optional.empty();
    }
}
