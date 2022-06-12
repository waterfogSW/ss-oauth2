package com.waterfogsw.ssoauth2.oauth.repository;

import com.waterfogsw.ssoauth2.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserId(String userId);
}
