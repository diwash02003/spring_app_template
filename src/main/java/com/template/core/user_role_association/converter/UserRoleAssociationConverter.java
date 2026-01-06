package com.template.core.user_role_association.converter;

import com.template.core.role.model.Role;
import com.template.core.user.model.User;
import com.template.core.user_role_association.dto.CreateUserRoleAssociationDto;
import com.template.core.user_role_association.model.UserRoleAssociation;
import org.springframework.stereotype.Component;

/**
 * @author diwash
 * @created 1/5/26
 */

@Component
public class UserRoleAssociationConverter {
    public UserRoleAssociation toEntity(CreateUserRoleAssociationDto dto, User user, Role role) {
        return UserRoleAssociation.builder()
                .user(user)
                .role(role)
                .effectiveFrom(dto.getEffectiveFrom())
                .effectiveTo(dto.getEffectiveTo())
                .build();
    }
}
