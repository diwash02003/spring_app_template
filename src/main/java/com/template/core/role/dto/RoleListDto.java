package com.template.core.role.dto;

import lombok.*;

/**
 * @author diwash
 * @created 1/6/26
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoleListDto {
    private Long id;
    private String name;
    private String description;
}