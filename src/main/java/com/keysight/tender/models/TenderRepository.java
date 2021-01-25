package com.keysight.tender.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;

public interface TenderRepository extends CrudRepository<Tender, Integer> {

    @Query
        List<Tender> findByDateStartLessThanEqualAndDateFinishGreaterThanEqual (ZonedDateTime dateFinish, ZonedDateTime dateStart);
   /* @Query
        List<Tender> findByDateStartLessThanEqualAndDateFinishGreaterThanEqualAndtypeid (ZonedDateTime dateFinish, ZonedDateTime dateStart, Typetender Typetender);
    @Query
        List<Tender> findByDateStartLessThanEqualAndDateFinishGreaterThanEqualAndtypeIdAndCustomerid (ZonedDateTime dateFinish, ZonedDateTime dateStart, Typetender Typetender, Customer Customer);
    @Query
        List<Tender> findByDateStartLessThanEqualAndDateFinishGreaterThanEqualAndCustomerId (ZonedDateTime dateFinish, ZonedDateTime dateStart, Customer Customer);
*/
    @Query(value = "SELECT * FROM keysight.tender where typetender Like :t",nativeQuery = true)
        List<Tender> findByTypetender_IdEndingWith(@Param("t") String t);
    @Query(value = "SELECT * FROM keysight.tender where date_start<=:dateFinish and date_finish>=:dateStart and typetender like :typetender "+
            " and customer like :customer and winner like :winner and sum >= :minSum and sum <= :maxSum",nativeQuery = true)
        List<Tender> SelectMyQuery(@Param("dateFinish") ZonedDateTime dateFinish,
                                   @Param("dateStart") ZonedDateTime dateStart,
                                   @Param("typetender") String typetender,
                                   @Param("customer") String customer,
                                   @Param("winner") String winner,
                                   @Param("minSum") long minSum,
                                   @Param("maxSum") long maxSum);
}
