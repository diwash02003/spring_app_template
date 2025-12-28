package com.template.core.country.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author diwash
 * @created 12/25/25
 */

@Table(name = "country")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Country {
    @Id
    @SequenceGenerator(name = "country_seq_gen", sequenceName = "country_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "country_seq_gen")
    private Long id;

    @Column(name = "name", nullable = false, columnDefinition = "varchar(100)")
    private String name;

    @Column(name = "code", unique = true)
    private String code;
}
