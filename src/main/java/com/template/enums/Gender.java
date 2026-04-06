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
public enum Gender {
    MALE("MALE", "Male"),
    FEMALE("FEMALE", "Female"),
    OTHERS("OTHERS", "Others");

    private final String key;
    private final String value;

    public static List<KeyValueDto> getAll() {
        return Arrays.stream(Gender.values())
                .map(g -> new KeyValueDto(g.getKey(), g.getValue()))
                .collect(Collectors.toList());
    }
}