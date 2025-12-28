package com.template.generics.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author diwash
 * @created 12/25/25
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KeyValueDto {

    private String key;
    private String value;
}

