package com.keysight.tender.models;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface TenderRepository extends CrudRepository<Tender, Integer> {
    public static final String find_finish = "Select date_finish from tender";
    @Query(value = find_finish, nativeQuery = true)
    List<Timestamp> findDateFinish();

    @Query
        List<Tender> findByDateStartGreaterThanEqualAndDateFinishLessThanEqual (LocalDateTime dateStart,  LocalDateTime dateFinish);
}
