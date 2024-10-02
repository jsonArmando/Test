package com.assessment.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assessment.entities.User;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    boolean existsByEmail(String email);
    User findByEmail(String email);
}