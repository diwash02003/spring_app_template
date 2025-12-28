package com.template.core.country.service.impl;

import com.template.core.country.entity.Country;
import com.template.core.country.repo.CountryRepo;
import com.template.core.country.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author diwash
 * @created 12/25/25
 */

@Service
public class CountryServiceImpl implements CountryService {
    private final CountryRepo countryRepository;

    public CountryServiceImpl(CountryRepo countryRepository) {
        this.countryRepository = countryRepository;
    }

    public List<Country> getAll() {
        return countryRepository.findAll();
    }
}
