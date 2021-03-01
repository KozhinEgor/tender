package com.keysight.tender.models;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface AnotherProductRepository extends CrudRepository<AnotherProduct,Integer> {
    @Query
    AnotherProduct findTopById(Long id);

}
