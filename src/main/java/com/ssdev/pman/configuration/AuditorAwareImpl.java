package com.ssdev.pman.configuration;

import com.ssdev.pman.entity.User;
import com.ssdev.pman.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Optional;
public class AuditorAwareImpl implements AuditorAware<Long> {
    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<Long> getCurrentAuditor() {
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        UserDetails userDetails = authentication != null ? (UserDetails) authentication.getPrincipal() : null;
        if (userDetails != null) {
            User user = userRepository.findUserByUserName(userDetails.getUsername());
            return Optional.of(user.getId());
        }
        return Optional.empty();
    }
}
