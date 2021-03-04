package com.keysight.tender.models;

import com.keysight.tender.controller.SearchAtribut;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.persistence.*;
import java.util.List;

public class OrdersModel {

    private Long id;
    private Tender tender;
    private String productCategory;
    private String product;
    private String commet;
    private int number;

    public OrdersModel(Orders orders,String product) {
        this.id = orders.getId();
        this.tender = orders.getTender();
        this.productCategory = orders.getProductCategory().getCategory();
        this.product = product;
        this.commet = orders.commet;
        this.number = orders.getNumber();
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

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String returnProduct(){
        return this.productCategory + " " + this.product + " (" + this.commet + ") - " + this.number;
    }
}
