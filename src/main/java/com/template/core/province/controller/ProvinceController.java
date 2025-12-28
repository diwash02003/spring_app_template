package com.template.core.province.controller;


import com.template.constants.MessageConstants;
import com.template.core.province.dto.ProvinceDto;
import com.template.core.province.service.ProvinceService;
import com.template.response.MessageParameter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author diwash
 * @created 12/25/25
 */

@RestController
@RequestMapping("/master/province")
public class ProvinceController {
    private final ProvinceService provinceService;

    public ProvinceController(ProvinceService provinceService) {
        this.provinceService = provinceService;
    }

    @GetMapping
    @MessageParameter(message = MessageConstants.SUCCESS_FETCH, source = MessageConstants.PROVINCE)
    public List<ProvinceDto> getProvinces() {
        return provinceService.getAll();
    }
}
