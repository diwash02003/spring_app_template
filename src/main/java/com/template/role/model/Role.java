package com.template.role.model;

import com.template.configuration.audit.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

/**
 * @author diwash
 * @created 12/9/25
 */

@Entity
@Table(name = "roles",
        uniqueConstraints = {
                @UniqueConstraint(name = "uq_roles_name", columnNames = "name")
        })
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Role extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "roles_seq_gen")
    @SequenceGenerator(name = "roles_seq_gen", sequenceName = "roles_seq", allocationSize = 1)
    private Long id;

    @Column(nullable = false, length = 30)
    private String name;

    private String description;
}