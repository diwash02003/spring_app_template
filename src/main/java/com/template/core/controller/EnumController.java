package com.template.core.controller;

import com.template.constants.EnumConstants;
import com.template.constants.MessageConstants;
import com.template.enums.Gender;
import com.template.enums.UserType;
import com.template.generics.dto.KeyValueDto;
import com.template.response.MessageParameter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author diwash
 * @created 12/25/25
 */

@RestController
@RequestMapping("/enum")
public class EnumController {

    @MessageParameter(message = MessageConstants.SUCCESS_FETCH, source = MessageConstants.ENUM)
    @GetMapping("/{enumType}")
    public List<KeyValueDto> findByEnumType(@PathVariable String enumType) {
        return findEnumList(enumType);
    }

    private List<KeyValueDto> findEnumList(String enumType) {
        return switch (enumType) {
            case EnumConstants.GENDER -> Gender.getEnumList();
            case EnumConstants.USER_TYPE -> UserType.getEnumList();
            default -> throw new IllegalArgumentException("Enum type not supported: " + enumType);
        };
    }
}
