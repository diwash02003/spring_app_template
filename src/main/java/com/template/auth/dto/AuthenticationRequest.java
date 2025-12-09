package com.template.auth.dto;

import com.template.constants.FieldErrorConstant;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author diwash
 * @created 12/9/25
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationRequest {

    @NotBlank(message = FieldErrorConstant.NOT_BLANK)
    private String usernameOrEmail;

    @NotBlank(message = FieldErrorConstant.NOT_BLANK)
    private String password;
}
