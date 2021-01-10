package com.keysight.tender.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import javax.persistence.*;

@Entity
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class ProductCategory {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
        Long id;
    @Column(unique=true)
        String category;

    public ProductCategory() {
    }
    public ProductCategory(String category) {
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getcategory() {
        return category;
    }

    public void setcategory(String category) {
        this.category = category;
    }
}
