package com.template.core.district.service;


import com.template.core.district.entity.District;

import java.util.List;

/**
 * @author diwash
 * @created 12/25/25
 */

public interface DistrictService {

    List<District> getByProvinceId(Long provinceId);

    List<District> getAll();
}
