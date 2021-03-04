package com.keysight.tender.models;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrdersRepository extends CrudRepository<Orders,Integer> {
    @Query
    Orders findTopById(Long Id);
    @Query
    List<Orders> findAllByTenderIn(List<Tender> tender);
    @Query
    List<Orders> findAllByTender(Tender tender);
}
