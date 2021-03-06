package com.ssafy.pollar.model.repository;

import com.ssafy.pollar.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,String> {
    Optional<User> findByUserId(String userId);
    Optional<User> findByUserNickname(String userNickname);
    Optional<User> findByUserEmail(String userEmail);
    Optional<User> findByUserIdAndPassword(String userId,String password);
}
