package com.template.configuration.security.service;

import com.template.configuration.security.user.CustomUserDetails;
import com.template.core.user.model.User;
import com.template.core.user.repo.UserRepository;
import com.template.core.user_role_association.repo.UserRoleAssociationRepository;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.NullMarked;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author diwash
 * @created 12/30/25
 */

@NullMarked
@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;
    private final UserRoleAssociationRepository userRoleAssociationRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsernameOrEmail(username, username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        // Fetch roles from association table
        List<GrantedAuthority> authorities = userRoleAssociationRepository.findByUser(user)
                .stream()
                .map(ura -> new SimpleGrantedAuthority(ura.getRole().getName()))
                .collect(Collectors.toList());

        return new CustomUserDetails(user, authorities);
    }
}
