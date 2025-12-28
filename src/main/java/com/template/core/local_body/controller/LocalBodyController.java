package com.template.core.local_body.controller;

import com.template.constants.MessageConstants;
import com.template.core.district.entity.District;
import com.template.core.local_body.entity.LocalBody;
import com.template.core.local_body.service.LocalBodyService;
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
@RequestMapping("/master/local-body")
@RequiredArgsConstructor
public class LocalBodyController {
    private final LocalBodyService localBodyService;

    @GetMapping
    @MessageParameter(message = MessageConstants.SUCCESS_FETCH, source = MessageConstants.LOCAL_BODY)
    public List<LocalBody> getAll() {
        return localBodyService.getAll();
    }

    @GetMapping("/by-district/{districtId}")
    @MessageParameter(message = MessageConstants.SUCCESS_FETCH, source = MessageConstants.DISTRICT)
    public List<LocalBody> getByDistrictId(@PathVariable Long districtId) {
        return localBodyService.getByDistrict(districtId);
    }


}
