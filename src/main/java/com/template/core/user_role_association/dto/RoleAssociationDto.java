package com.template.core.user_role_association.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author diwash
 * @created 1/5/26
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoleAssociationDto {
    private String name;
    private Integer id;
    private String effectiveFrom;
    private String effectiveTo;
}