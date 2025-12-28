package com.template.enums;

import com.template.generics.dto.KeyValueDto;

import java.util.Arrays;
import java.util.List;

/**
 * @author diwash
 * @created 12/25/25
 */

public enum Gender {
    MALE("MALE", "Male"),
    FEMALE("FEMALE", "Female"),
    OTHERS("OTHERS", "Others");

    private final String key;

    private final String value;

    Gender(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public static List<KeyValueDto> getEnumList() {
        return Arrays.stream(Gender.values())
                .map(x -> new KeyValueDto(x.value, x.name()))
                .toList();
    }
}