package com.keysight.tender.models;

import com.keysight.tender.controller.SearchAtribut;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.persistence.*;
import java.util.List;

public class OrdersModel {
   // @Autowired
    //private WinnerRepository winnerRepository;
    @NotNull
    private Long id;
    @NotNull
    private String tender;

    @NotNull
    private String productCategory;
    @NotNull
    private String product;
    @NotNull
    private String commet;

    public OrdersModel(Orders orders, String product) {
        this.id = orders.getId();
        this.tender = orders.getTender().getnameTender();
        this.productCategory = orders.getProductCategory().getCategory();
        this.product = product;
        this.commet = orders.commet;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTender() {
        return tender;
    }

    public void setTender(Tender tender) {
        this.tender = tender.getnameTender();
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory.getCategory();
    }

    public String getId_product() {
        return product;
    }

    public void setId_product(String product) {
        this.product = product;
    }

    public String getCommet() {
        return commet;
    }

    public void setCommet(String commet) {
        this.commet = commet;
    }
}
