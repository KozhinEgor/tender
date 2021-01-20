package com.keysight.tender.models;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
    @Query
    List<Customer> findTopByInn(String inn);
    @Query
    List <Customer> findTopByName(String name);
    @Query
    List <Customer> findTopByInnAndName(String inn, String name);
}
