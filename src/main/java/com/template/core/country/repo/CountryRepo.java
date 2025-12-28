package com.template.core.country.repo;

import com.template.core.country.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author diwash
 * @created 12/25/25
 */

public interface CountryRepo extends JpaRepository<Country, Long> {
}
