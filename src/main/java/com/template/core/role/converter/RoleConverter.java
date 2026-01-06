package com.template.core.role.converter;

import com.template.core.role.dto.RoleListDto;
import com.template.core.role.model.Role;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author diwash
 * @created 1/6/26
 */

@Component
public class RoleConverter {

    public RoleListDto toDto(Role role) {
        if (role == null) return null;
        return RoleListDto.builder()
                .id(role.getId())
                .name(role.getName())
                .description(role.getDescription())
                .build();
    }

    public List<RoleListDto> toDto(List<Role> roleList) {
        if (roleList.isEmpty()) return new ArrayList<>();
        return roleList.stream()
                .map(this::toDto)
                .toList();
    }
}
