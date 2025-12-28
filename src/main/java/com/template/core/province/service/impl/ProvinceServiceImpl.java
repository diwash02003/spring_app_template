package com.template.core.province.service.impl;

import com.template.core.province.dto.ProvinceDto;
import com.template.core.province.entity.Province;
import com.template.core.province.repo.ProvinceRepo;
import com.template.core.province.service.ProvinceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author diwash
 * @created 12/25/25
 */

@Service
@RequiredArgsConstructor
public class ProvinceServiceImpl implements ProvinceService {
    private final ProvinceRepo provinceRepo;

    @Override
    public List<ProvinceDto> getAll() {
        List<Province> provinces = this.provinceRepo.findAll();
        return provinces.stream()
                .map(p -> new ProvinceDto(p.getId(), p.getName(), p.getCode()))
                .toList();
    }
}
