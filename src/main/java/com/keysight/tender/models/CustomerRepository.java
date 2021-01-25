package com.keysight.tender.models;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
    @Query
    Customer findTopById(Long id);
    @Query
    List <Customer> findTopByInnAndName(String inn, String name);
}
