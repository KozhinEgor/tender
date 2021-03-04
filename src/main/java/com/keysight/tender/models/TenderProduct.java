package com.keysight.tender.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class TenderProduct {
    Long id;
    private  String customer;
    private String nameTender;
    private String numberTender;
    private String bicoTender;
    private String gosZakupki;
    private String typetender;
    private BigDecimal price;
    private String currency;
    private double rate;
    private BigDecimal sum;
    private ZonedDateTime dateStart;
    private  ZonedDateTime dateFinish;
    private BigDecimal fullSum;
    private BigDecimal winSum;
    private String winner;
    private String product;

    public TenderProduct() {
    }
    public TenderProduct(Tender tender, ArrayList<OrdersModel> ordersModels) {
        this.id = tender.getId();
        this.customer = tender.getCustomer();
        this.nameTender = tender.getnameTender();
        this.numberTender = tender.getnumberTender();
        this.bicoTender = tender.getbicoTender();
        this.gosZakupki = tender.getgosZakupki();
        this.typetender = tender.gettypetender();
        this.price = tender.getPrice();
        this.currency = tender.getCurrency();
        this.rate = tender.getRate();
        this.sum = tender.getSum();
        this.dateStart = tender.getdateStart();
        this.dateFinish = tender.getdateFinish();
        this.fullSum = tender.getfullSum();
        this.winSum = tender.getwinSum();
        this.winner = tender.getwinner();
        for (OrdersModel ordersModel : ordersModels){
            this.product = this.product + "; " + ordersModel.returnProduct();
        }
        System.out.println(this.id);
        this.product = this.product.substring(this.product.indexOf(";")+2);
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getNameTender() {
        return nameTender;
    }

    public void setNameTender(String nameTender) {
        this.nameTender = nameTender;
    }

    public String getNumberTender() {
        return numberTender;
    }

    public void setNumberTender(String numberTender) {
        this.numberTender = numberTender;
    }

    public String getBicoTender() {
        return bicoTender;
    }

    public void setBicoTender(String bicoTender) {
        this.bicoTender = bicoTender;
    }

    public String getGosZakupki() {
        return gosZakupki;
    }

    public void setGosZakupki(String gosZakupki) {
        this.gosZakupki = gosZakupki;
    }

    public String getTypetender() {
        return typetender;
    }

    public void setTypetender(String typetender) {
        this.typetender = typetender;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }

    public ZonedDateTime getDateStart() {
        return dateStart;
    }

    public void setDateStart(ZonedDateTime dateStart) {
        this.dateStart = dateStart;
    }

    public ZonedDateTime getDateFinish() {
        return dateFinish;
    }

    public void setDateFinish(ZonedDateTime dateFinish) {
        this.dateFinish = dateFinish;
    }

    public BigDecimal getFullSum() {
        return fullSum;
    }

    public void setFullSum(BigDecimal fullSum) {
        this.fullSum = fullSum;
    }

    public BigDecimal getWinSum() {
        return winSum;
    }

    public void setWinSum(BigDecimal winSum) {
        this.winSum = winSum;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }
}
