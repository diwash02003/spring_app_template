package com.template.core.user_role_association.service.impl;

import com.template.constants.MessageConstants;
import com.template.core.role.model.Role;
import com.template.core.role.service.RoleService;
import com.template.core.user.model.User;
import com.template.core.user.service.UserService;
import com.template.core.user_role_association.converter.UserRoleAssociationConverter;
import com.template.core.user_role_association.dto.CreateUserRoleAssociationDto;
import com.template.core.user_role_association.dto.RemoveMappingDto;
import com.template.core.user_role_association.model.UserRoleAssociation;
import com.template.core.user_role_association.repo.UserRoleAssociationRepository;
import com.template.core.user_role_association.service.UserRoleAssociationService;
import com.template.exception.custom.ResourceNotFoundException;
import com.template.response.CustomMessageSource;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Optional;

/**
 * @author diwash
 * @created 1/6/26
 */

@Service
@RequiredArgsConstructor
@Slf4j
public class UserRoleAssociationServiceImpl implements UserRoleAssociationService {
    private final UserRoleAssociationRepository userRoleAssociationRepo;
    private final RoleService roleService;
    private final UserService userService;
    private final UserRoleAssociationConverter userRoleAssociationConverter;
    private final CustomMessageSource customMessageSource;

    @Override
    @Transactional
    public Integer createAssociation(CreateUserRoleAssociationDto dto) {
        Optional<UserRoleAssociation> existingMapping = userRoleAssociationRepo.findUserRoleMapping(dto.getRoleId(), dto.getUserId());
        if (existingMapping.isPresent()) {
            return existingMapping.get().getId();
        }
        Role role = roleService.findEntityById(dto.getRoleId());
        User user = userService.findEntityById(dto.getUserId());
        UserRoleAssociation mapping = userRoleAssociationConverter.toEntity(dto, user, role);
        return userRoleAssociationRepo.save(mapping).getId();
    }

    @Transactional
    @Override
    public Integer removeAssociation(RemoveMappingDto dto) {
        UserRoleAssociation association = userRoleAssociationRepo.findUserRoleMapping(dto.getRoleId(), dto.getUserId()).orElseThrow(() ->
                new ResourceNotFoundException(customMessageSource.get(MessageConstants.NOT_FOUND,
                        customMessageSource.get(MessageConstants.ASSOCIATION)))
        );
        association.setEffectiveTo(LocalDate.now());
        userRoleAssociationRepo.save(association);
        return association.getId();
    }
}

