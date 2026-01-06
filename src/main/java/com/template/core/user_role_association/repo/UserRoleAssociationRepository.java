package com.template.core.user_role_association.repo;

import com.template.core.user.model.User;
import com.template.core.user_role_association.model.UserRoleAssociation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * @author diwash
 * @created 12/30/25
 */

public interface UserRoleAssociationRepository extends JpaRepository<UserRoleAssociation, Long> {
    List<UserRoleAssociation> findByUser(User user);

    @Query(value = "select a from UserRoleAssociation  a where a.user.id = :userId and a.role.id = :roleId")
    Optional<UserRoleAssociation> findUserRoleMapping(Long roleId, Long userId);

    @Query("""
                SELECT ura FROM UserRoleAssociation ura WHERE ura.user = :user
                  AND ura.effectiveFrom <= :today AND (ura.effectiveTo IS NULL OR ura.effectiveTo >= :today)
            """)
    List<UserRoleAssociation> findActiveValidRoles(@Param("user") User user, @Param("today") LocalDate today);
}
