package com.template.core.user_role_association.repo;

import com.template.core.user.model.User;
import com.template.core.user_role_association.model.UserRoleAssociation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author diwash
 * @created 12/30/25
 */

public interface UserRoleAssociationRepository extends JpaRepository<UserRoleAssociation, Long> {
    List<UserRoleAssociation> findByUser(User user);
}
