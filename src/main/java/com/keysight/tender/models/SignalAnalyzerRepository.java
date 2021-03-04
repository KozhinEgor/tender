package com.keysight.tender.models;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface SignalAnalyzerRepository extends CrudRepository<SignalAnalyzer,Integer> {
    @Query
    SignalAnalyzer findTopById(Long id);
    @Query
    SignalAnalyzer findTopByVendorCode(String vendoreCode);
}
