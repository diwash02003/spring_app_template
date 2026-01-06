package com.template.core.user_role_association.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

/**
 * @author diwash
 * @created 1/5/26
 */

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class RemoveMappingDto {
    @NotNull
    private Long userId;
    @NotNull
    private Long roleId;
}

