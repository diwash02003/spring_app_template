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

@Table(
        name = "province",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_province_code", columnNames = {"code"})
        }
)
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Province {

    @Id
    @SequenceGenerator(name = "province_seq_gen", sequenceName = "province_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "province_seq_gen")
    private Long id;

    @Column(name = "name", nullable = false, length = 25)
    private String name;

    @Column(name = "code", unique = true, length = 5)
    private String code;
}
