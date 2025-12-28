package com.template.core.local_body.service;

import com.template.core.local_body.entity.LocalBody;

import java.util.List;

/**
 * @author diwash
 * @created 12/25/25
 */

public interface LocalBodyService {

    List<LocalBody> getByDistrict(Long districtId);

    List<LocalBody> getAll();
}
