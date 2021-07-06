package com.hebe.jwt.repository;

import com.hebe.vo.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, String> {
    UserEntity findByEmail(String email);
}