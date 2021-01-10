package com.keysight.tender.models;

import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductCategoryRepository {
    @Query
    List<Typetender> findTopByCategory(String Category);
}
