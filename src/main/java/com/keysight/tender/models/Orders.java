package com.keysight.tender.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.keysight.tender.controller.SearchAtribut;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;
import java.util.Set;


@Entity
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Orders {


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long id;
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "tender",nullable = false)
        private Tender tender;
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "productCategory",nullable = false)
    private ProductCategory productCategory;
    @Column(nullable = false)
    Long id_product;
    @Column(nullable = false)
    String commet ;
    @Column(nullable = false)
    int number;

    public Orders() {
    }

    public Orders(Tender tender, ProductCategory productCategory, Long id_product, String commet, int number) {
        this.tender = tender;
        this.productCategory = productCategory;
        this.id_product = id_product;
        this.commet = commet;
        this.number = number;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Tender getTender() {
        return tender;
    }

    public void setTender(Tender tender) {
        this.tender = tender;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public Long getId_product() {
        return id_product;
    }

    public void setId_product(Long id_product) {
        this.id_product = id_product;
    }

    public String getCommet() {
        return commet;
    }

    public void setCommet(String commet) {
        this.commet = commet;
    }
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

}

