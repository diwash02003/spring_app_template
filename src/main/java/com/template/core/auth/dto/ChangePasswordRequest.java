package com.template.core.auth.dto;

import com.template.constants.FieldErrorConstant;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author diwash
 * @created 12/10/25
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChangePasswordRequest {
    @NotBlank(message = FieldErrorConstant.NOT_BLANK)
    private String currentPassword;

    @NotBlank(message = FieldErrorConstant.NOT_BLANK)
    private String newPassword;

    @NotBlank(message = FieldErrorConstant.NOT_BLANK)
    private String confirmPassword;
}
