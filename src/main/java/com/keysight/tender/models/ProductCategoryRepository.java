package com.keysight.tender.models;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductCategoryRepository extends CrudRepository<ProductCategory, Integer> {
    @Query
    List<ProductCategory> findTopByCategory(String Category);
}
