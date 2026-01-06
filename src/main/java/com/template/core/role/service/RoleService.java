package com.template.core.role.service;

import com.template.core.role.dto.RoleListDto;
import com.template.core.role.model.Role;

import java.util.List;

/**
 * @author diwash
 * @created 1/6/26
 */

public interface RoleService {
    Role findEntityById(Long id);

    Role findEntityByName(String roleName);

    List<RoleListDto> findAll();
}
