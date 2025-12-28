package com.template.core.country.controller;

import com.template.constants.MessageConstants;
import com.template.core.country.entity.Country;
import com.template.core.country.service.CountryService;
import com.template.response.MessageParameter;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author diwash
 * @created 12/25/25
 */

@RestController
@RequestMapping("/master/country")
@AllArgsConstructor
public class CountryController {

    private CountryService countryService;

    @GetMapping
    @MessageParameter(message = MessageConstants.SUCCESS_FETCH, source = MessageConstants.COUNTRY)
    public List<Country> findAll() {
        return countryService.getAll();
    }

}
