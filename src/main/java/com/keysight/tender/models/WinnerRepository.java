package com.keysight.tender.models;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface WinnerRepository extends CrudRepository<Winner, Integer> {
    @Query
        List<Winner> findTopByInn(String inn);
    @Query
        List<Winner> findTopByName(String name);
    @Query
        List<Winner> findTopByOgrn(String ogrn);
    @Query
        List<Winner> findTopByInnAndName(String Inn,String Name);
    @Query
        List<Winner> findByid(Long id);
}
