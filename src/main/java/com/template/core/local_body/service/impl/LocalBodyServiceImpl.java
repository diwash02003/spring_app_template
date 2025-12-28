package com.template.core.local_body.service.impl;

import com.template.constants.MessageConstants;
import com.template.core.district.entity.District;
import com.template.core.district.repo.DistrictRepo;
import com.template.core.local_body.entity.LocalBody;
import com.template.core.local_body.repo.LocalBodyRepo;
import com.template.core.local_body.service.LocalBodyService;
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
public class LocalBodyServiceImpl implements LocalBodyService {


    private final DistrictRepo districtRepo;
    private final LocalBodyRepo localBodyRepo;
    private final CustomMessageSource customMessageSource;

    @Override
    public List<LocalBody> getByDistrict(Long districtId) {
        District district = districtRepo.findById(districtId).orElseThrow(() -> new RuntimeException(customMessageSource.get(MessageConstants.NOT_FOUND, MessageConstants.DISTRICT)));
        return localBodyRepo.findAllByDistrictOrderByName(district);
    }

    @Override
    public List<LocalBody> getAll() {
        return localBodyRepo.findAllByOrderByName();
    }
}
