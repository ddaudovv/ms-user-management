package com.ms.rest.user.management.repository;

import com.ms.rest.user.management.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    List<UserEntity> findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCaseOrEmailAddressContainingIgnoreCase(String firstName, String lastName, String emailAddress);
}
