package com.template.role.model;

import com.template.configuration.audit.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

/**
 * @author diwash
 * @created 12/9/25
 */

@Entity
@Table(name = "roles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Role extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    private String description;
}