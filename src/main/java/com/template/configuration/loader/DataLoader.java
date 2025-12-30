package com.template.configuration.loader;

import com.template.constants.RoleConstant;
import com.template.enums.UserType;
import com.template.core.role.model.Role;
import com.template.core.role.repo.RoleRepository;
import com.template.core.user.model.User;
import com.template.core.user.repo.UserRepository;
import com.template.core.user_role_association.model.UserRoleAssociation;
import com.template.core.user_role_association.repo.UserRoleAssociationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

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
    private final UserRoleAssociationRepository userRoleAssociationRepository;
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

        // 2. Create admin user if not exists
        User admin = userRepository.findByUsername("admin")
                .orElseGet(() -> {
                    User newUser = User.builder()
                            .username("admin")
                            .email("admin@example.com")
                            .firstName("admin")
                            .lastName("user")
                            .password(passwordEncoder.encode("admin"))
                            .enabled(true)
                            .locked(false)
                            .userType(UserType.SUPER_ADMIN)
                            .build();
                    return userRepository.save(newUser);
                });

        // 3. Create role associations
        if (userRoleAssociationRepository.findByUser(admin).isEmpty()) {
            UserRoleAssociation adminUserRole = new UserRoleAssociation();
            adminUserRole.setUser(admin);
            adminUserRole.setRole(adminRole);
            userRoleAssociationRepository.save(adminUserRole);

            UserRoleAssociation userUserRole = new UserRoleAssociation();
            userUserRole.setUser(admin);
            userUserRole.setRole(userRole);
            userRoleAssociationRepository.save(userUserRole);

            log.info("Admin user-role associations created.");
        } else {
            log.info("Admin user-role associations already exist. Skipping creation.");
        }
        log.info("Data loader finished.");
    }
}
