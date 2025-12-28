package com.template.core.district.service.impl;

import com.template.constants.MessageConstants;
import com.template.core.district.entity.District;
import com.template.core.district.repo.DistrictRepo;
import com.template.core.district.service.DistrictService;
import com.template.core.province.entity.Province;
import com.template.core.province.repo.ProvinceRepo;
import com.template.response.CustomMessageSource;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author diwash
 * @created 12/25/25
 */

@Service
@RequiredArgsConstructor
public class DistrictServiceImpl implements DistrictService {
    private final DistrictRepo districtRepo;
    private final ProvinceRepo provinceRepo;
    private final CustomMessageSource customMessageSource;

    @Override
    public List<District> getByProvinceId(Long provinceId) {
        Province province = provinceRepo.findById(provinceId).orElseThrow(() -> new RuntimeException(customMessageSource.get(MessageConstants.NOT_FOUND, MessageConstants.PROVINCE)));
        return districtRepo.findAllByProvince(province);
    }

    @Override
    public List<District> getAll() {
        return this.districtRepo.findAll();
    }
}
