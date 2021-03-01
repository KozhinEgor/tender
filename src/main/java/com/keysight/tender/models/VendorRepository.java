package com.keysight.tender.models;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VendorRepository extends CrudRepository<Vendor,Integer> {
    @Query
    List<Vendor> findTopByName(String name);
    @Query
    Vendor findTopById(Long id);
}
