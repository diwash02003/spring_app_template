package com.template.core.user_role_association.service;

import com.template.core.user_role_association.dto.CreateUserRoleAssociationDto;
import com.template.core.user_role_association.dto.RemoveMappingDto;

/**
 * @author diwash
 * @created 1/6/26
 */

public interface UserRoleAssociationService {
    Integer createAssociation(CreateUserRoleAssociationDto createUserRoleAssociationDto);

    Integer removeAssociation(RemoveMappingDto removeMappingDto);
}
