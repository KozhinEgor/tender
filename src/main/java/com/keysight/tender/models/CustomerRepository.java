package com.keysight.tender.models;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
    @Query
    List<Customer> findTopByINN(String INN);
    @Query
    List <Customer> findTopByName(String Name);
    @Query
    List <Customer> findTopByINNAndName(String INN, String Name);
}
