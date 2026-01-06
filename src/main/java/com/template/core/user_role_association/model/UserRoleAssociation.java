package com.template.core.user_role_association.model;

import com.template.configuration.audit.model.BaseEntity;
import com.template.core.role.model.Role;
import com.template.core.user.model.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

/**
 * @author diwash
 * @created 12/30/25
 */

@Entity
@Table(name = "user_role_association")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserRoleAssociation extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "user_role_association_seq_gen")
    @SequenceGenerator(name = "user_role_association_seq_gen", sequenceName = "user_role_association_seq", initialValue = 1, allocationSize = 1)
    private Integer id;

    @ManyToOne(cascade = {CascadeType.DETACH})
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "fk_user_role_association_user_id"))
    private User user;

    @ManyToOne(cascade = {CascadeType.DETACH})
    @JoinColumn(name = "role_id", foreignKey = @ForeignKey(name = "fk_fk_user_role_association_role_id"))
    private Role role;

    @Column(name = "effective_from")
    private LocalDate effectiveFrom;

    @Column(name = "effective_to")
    private LocalDate effectiveTo;
}
