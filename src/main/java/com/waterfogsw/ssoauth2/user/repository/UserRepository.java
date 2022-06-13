package com.waterfogsw.ssoauth2.user.repository;

import com.waterfogsw.ssoauth2.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserId(String userId);
}
