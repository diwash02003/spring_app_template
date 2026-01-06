package com.template.core.user_role_association.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

/**
 * @author diwash
 * @created 1/5/26
 */

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class CreateUserRoleAssociationDto {

    @NotNull
    private Long userId;

    @NotNull
    private Long roleId;

    @NotNull
    private LocalDate effectiveFrom;

    private LocalDate effectiveTo;
}

