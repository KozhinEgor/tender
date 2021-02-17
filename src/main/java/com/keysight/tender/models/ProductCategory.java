package com.keysight.tender.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import org.springframework.lang.NonNull;

import javax.persistence.*;

@Entity
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class ProductCategory {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
        Long id;
    @Column(nullable = false, unique=true)
        String category;
    @Column(nullable = false)
        String category_en;

    public ProductCategory() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategory_en() {
        return category_en;
    }

    public void setCategory_en(String category_en) {
        this.category_en = category_en;
    }
}
