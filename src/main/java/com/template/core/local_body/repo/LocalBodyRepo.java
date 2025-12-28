package com.template.core.local_body.repo;

import com.template.core.district.entity.District;
import com.template.core.local_body.entity.LocalBody;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author diwash
 * @created 12/25/25
 */

public interface LocalBodyRepo extends JpaRepository<LocalBody, Long> {

    List<LocalBody> findAllByDistrictOrderByName(District district);

    List<LocalBody> findAllByOrderByName();
}
