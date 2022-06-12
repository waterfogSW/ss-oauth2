package com.waterfogsw.ssoauth2.oauth.service;

import com.waterfogsw.ssoauth2.oauth.entity.UserPrincipal;
import com.waterfogsw.ssoauth2.oauth.repository.UserRepository;
import io.jsonwebtoken.lang.Assert;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static org.apache.logging.log4j.util.Strings.isNotEmpty;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Assert.isTrue(isNotEmpty(username), "Username must be provided");

        final var user = userRepository.findByUserId(username);

        if (user == null) {
            throw new UsernameNotFoundException("Username not found.");
        }

        return UserPrincipal.create(user);
    }
}
