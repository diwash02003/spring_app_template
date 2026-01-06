package com.template.core.user.service.impl;

import com.template.constants.MessageConstants;
import com.template.core.user.model.User;
import com.template.core.user.repo.UserRepository;
import com.template.core.user.service.UserService;
import com.template.exception.custom.ResourceNotFoundException;
import com.template.response.CustomMessageSource;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author diwash
 * @created 1/6/26
 */

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final CustomMessageSource customMessageSource;

    @Override
    public User findEntityById(Long id) {
        return userRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException(
                        customMessageSource.get(MessageConstants.NOT_FOUND,
                                customMessageSource.get(MessageConstants.USER)))
        );
    }
}
