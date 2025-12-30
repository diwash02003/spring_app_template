package com.template.core.auth.dto;

import com.template.constants.FieldErrorConstant;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.repository.cdi.Eager;

/**
 * @author diwash
 * @created 12/10/25
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ForgotPasswordRequest {
    @NotBlank(message = FieldErrorConstant.NOT_BLANK)
    @Email(message = FieldErrorConstant.VALID)
    private String email;
}
