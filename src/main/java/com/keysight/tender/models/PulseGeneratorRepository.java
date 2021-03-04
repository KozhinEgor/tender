package com.keysight.tender.models;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PulseGeneratorRepository extends CrudRepository<PulseGenerator,Integer> {
    @Query
    PulseGenerator findTopById(Long id);
    @Query
    PulseGenerator findTopByVendorCode(String vendoreCode);
}
