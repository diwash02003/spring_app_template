package com.template.enums;

import com.template.generics.dto.KeyValueDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author diwash
 * @created 12/25/25
 */

@Getter
@AllArgsConstructor
public enum UserType {
    SUPER_ADMIN("SUPER_ADMIN", "Super Admin");

    private final String key;
    private final String value;

    public static List<KeyValueDto> getAll() {
        return Arrays.stream(UserType.values())
                .map(ut -> new KeyValueDto(ut.getKey(), ut.getValue()))
                .collect(Collectors.toList());
    }
}
