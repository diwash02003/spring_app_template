package com.template.core.province.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author diwash
 * @created 12/25/25
 */

@Table(name = "province")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Province {

    @Id
    @SequenceGenerator(name = "province_seq_gen", sequenceName = "province_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "province_seq_gen")
    private Long id;

    @Column(name = "name", nullable = false, columnDefinition = "varchar(100)")
    private String name;

    @Column(name = "code", unique = true)
    private String code;
}
