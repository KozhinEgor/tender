package com.keysight.tender.models;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface OscilloscopeRepository extends CrudRepository<Oscilloscope,Integer> {
    @Query
    Oscilloscope findTopById(Long id);
}
