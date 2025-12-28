package com.template.core.district.repo;


import com.template.core.district.entity.District;
import com.template.core.province.entity.Province;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author diwash
 * @created 12/25/25
 */

public interface DistrictRepo extends JpaRepository<District, Long> {
    List<District> findAllByProvince(Province province);
}