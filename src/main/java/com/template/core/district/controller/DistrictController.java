package com.template.core.district.controller;

import com.template.constants.MessageConstants;
import com.template.core.district.entity.District;
import com.template.core.district.service.DistrictService;
import com.template.response.MessageParameter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author diwash
 * @created 12/25/25
 */

@RestController
@RequestMapping("/master/district")
@RequiredArgsConstructor
public class DistrictController {
    private final DistrictService districtService;

    @GetMapping()
    @MessageParameter(message = MessageConstants.SUCCESS_FETCH, source = MessageConstants.DISTRICT)
    public List<District> getAll() {
        return districtService.getAll();
    }

    @GetMapping("/by-province/{provinceId}")
    @MessageParameter(message = MessageConstants.SUCCESS_FETCH, source = MessageConstants.DISTRICT)
    public List<District> getByProvinceId(@PathVariable Long provinceId) {
        return districtService.getByProvinceId(provinceId);
    }
}
