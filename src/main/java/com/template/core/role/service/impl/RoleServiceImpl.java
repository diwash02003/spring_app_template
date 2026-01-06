package com.template.core.role.service.impl;

import com.template.constants.MessageConstants;
import com.template.core.role.converter.RoleConverter;
import com.template.core.role.dto.RoleListDto;
import com.template.core.role.model.Role;
import com.template.core.role.repo.RoleRepository;
import com.template.core.role.service.RoleService;
import com.template.exception.custom.ResourceNotFoundException;
import com.template.response.CustomMessageSource;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author diwash
 * @created 1/6/26
 */

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepo;
    private final CustomMessageSource customMessageSource;
    private final RoleConverter roleConverter;

    @Override
    public Role findEntityById(Long id) {
        return roleRepo.findById(id).orElseThrow(() ->
                new ResourceNotFoundException(customMessageSource.get(MessageConstants.NOT_FOUND,
                        customMessageSource.get(MessageConstants.ROLE))));
    }

    @Override
    public Role findEntityByName(String roleName) {
        return roleRepo.findByName(roleName).orElseThrow(() ->
                new ResourceNotFoundException(customMessageSource.get(MessageConstants.NOT_FOUND,
                        customMessageSource.get(MessageConstants.ROLE))));
    }

    @Override
    public List<RoleListDto> findAll() {
        List<Role> roles = roleRepo.findAll();
        return roleConverter.toDto(roles);
    }
}
