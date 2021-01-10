package com.keysight.tender.models;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface TypetenderRepository extends CrudRepository<Typetender, Integer> {
    @Query
    List<Typetender> findByType(String type);

}
