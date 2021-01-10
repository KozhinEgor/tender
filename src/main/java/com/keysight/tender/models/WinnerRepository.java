package com.keysight.tender.models;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface WinnerRepository extends CrudRepository<Winner, Integer> {
    @Query
        List<Winner> findTopByINN(String INN);
    @Query
        List<Winner> findTopByName(String name);
    @Query
        List<Winner> findTopByOGRN(String OGRN);
    @Query
        List<Winner> findTopByINNAndName(String INN,String Name);
    @Query
        List<Winner> findByid(Long id);
}
