package com.template.configuration.audit;

import com.template.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;

/**
 * @author diwash
 * @created 12/9/25
 */

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditProvider")
@RequiredArgsConstructor
public class JpaAuditingConfig {
    private final JwtUtil jwtUtil;

    @Bean
    public AuditorAware<Long> auditProvider() {
        return () -> Optional.of(jwtUtil.getCurrentUserId());
    }
}
