package com.keysight.tender.models;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface SpectrumAnalyserRepository extends CrudRepository<SpectrumAnalyser, Integer> {
    @Query
        SpectrumAnalyser findTopById(Long id);
    @Query
    SpectrumAnalyser findTopByVendorCode(String vendorCode);
}
