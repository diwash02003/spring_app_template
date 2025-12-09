package com.template.configuration.loader;

import com.template.constants.RoleConstant;
import com.template.role.model.Role;
import com.template.role.repo.RoleRepository;
import com.template.user.model.User;
import com.template.user.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Set;

/**
 * @author diwash
 * @created 12/9/25
 */


@Slf4j
@Configuration
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {
        // create roles
        Role adminRole = roleRepository.findByName(RoleConstant.ADMIN)
                .orElseGet(() -> roleRepository.save(Role.builder()
                        .name(RoleConstant.ADMIN)
                        .build()));

        Role userRole = roleRepository.findByName(RoleConstant.USER)
                .orElseGet(() -> roleRepository.save(Role.builder()
                        .name(RoleConstant.USER)
                        .build()));

        // create admin user
        if (!userRepository.existsByUsername("admin")) {
            Set<Role> roles = new HashSet<>();
            roles.add(adminRole);
            roles.add(userRole);


            User admin = User.builder()
                    .username("admin")
                    .email("admin@example.com")
                    .firstName("admin")
                    .lastName("user")
                    .password(passwordEncoder.encode("admin"))
                    .enabled(true)
                    .locked(false)
                    .roles(roles)
                    .build();

            userRepository.save(admin);
            log.info("Admin user created: username=admin password=admin123");
        } else {
            log.info("Admin user already exists. Skipping creation.");
        }
    }

}
