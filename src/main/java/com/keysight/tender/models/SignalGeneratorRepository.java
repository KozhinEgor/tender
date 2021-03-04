package com.keysight.tender.models;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface SignalGeneratorRepository extends CrudRepository<SignalGenerator,Integer> {
    @Query
    SignalGenerator findTopById(Long id);
    @Query
    SignalGenerator findTopByVendorCode(String vendoreCode);
}
