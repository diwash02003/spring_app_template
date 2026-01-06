package com.template.core.user.service;

import com.template.core.user.model.User;

/**
 * @author diwash
 * @created 1/6/26
 */

public interface UserService {
    User findEntityById(Long id);
}
