package com.template.enums;

import com.template.exception.custom.EnumNotFoundException;
import com.template.generics.dto.KeyValueDto;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

/**
 * @author diwash
 * @created 12/25/25
 */

@Getter
public enum UserType {

    SUPER_ADMIN(0, "Super Admin");


    private final Integer key;
    private final String value;

    UserType(Integer key, String value) {
        this.key = key;
        this.value = value;
    }

    public static UserType getByKey(Integer key) {
        if (key == null) return null;

        UserType[] typeList = values();
        for (UserType type : typeList) {
            if (key.equals(type.key)) {
                return type;
            }
        }
        throw new EnumNotFoundException("User Type Not Found");
    }

    public static List<KeyValueDto> getEnumList() {
        return Arrays.stream(UserType.values())
                .filter(x -> x != UserType.SUPER_ADMIN)   // EXCLUDE SUPER_ADMIN
                .map(x -> new KeyValueDto(x.value, x.name()))
                .toList();
    }

}
