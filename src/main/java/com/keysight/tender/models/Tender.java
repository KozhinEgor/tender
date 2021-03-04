package com.keysight.tender.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Set;

@Entity
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Tender {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
        Long id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "customer",nullable = false)
        private  Customer customer;
    @Lob
    @Column(nullable = false, length = 1024)
        private String nameTender;
    @Column(nullable = false)
        private String numberTender;
    @Column(nullable = false)
        private String bicoTender;
    @Lob
    @Column(nullable = false)
        private String gosZakupki;


    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name= "typetender", nullable = false)
        private Typetender typetender;
    @Column(nullable = false)
        private BigDecimal price;
    @Column(nullable = false)
        private String currency;
    @Column(nullable = false)
        private double rate;
    @Column(nullable = false)
        private BigDecimal sum;


    @Column(nullable = false)
        private ZonedDateTime dateStart;


    @Column(nullable = false)
        private  ZonedDateTime dateFinish;
    @Column(nullable = false)
        private BigDecimal fullSum;
    @Column(nullable = false)
        private BigDecimal winSum;


    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "winner",nullable = false)
        private Winner winner;

    @JsonIgnore
    @XmlTransient
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "tender")
    private Set<Orders> Orders;

    public Tender() {
    }

    public Tender(com.keysight.tender.models.Customer customer,
                  String nameTender, String numberTender, String bicoTender,
                  String gosZakupki, com.keysight.tender.models.Typetender typetender,
                  BigDecimal price, String currency, double rate,
                  ZonedDateTime dateStart, ZonedDateTime dateFinish,
                  com.keysight.tender.models.Winner winner) {
        this.customer = customer;
        this.nameTender = nameTender;
        this.numberTender = numberTender;
        this.bicoTender = bicoTender;
        this.gosZakupki = gosZakupki;
        this.typetender = typetender;
        this.price = price;
        this.currency = currency;
        this.rate = rate;
        this.sum = new BigDecimal(rate).multiply(price);
        this.dateStart = dateStart;
        this.dateFinish = dateFinish;
        fullSum = sum;
        winSum = new BigDecimal(0);
        this.winner = winner;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomer() {
        return customer.getname();
    }

    public void setcustomer(com.keysight.tender.models.Customer customer) {
        this.customer = customer;
    }

    public String getnameTender() {
        return nameTender;
    }

    public void setnameTender(String nameTender) {
        this.nameTender = nameTender;
    }

    public String getnumberTender() {
        return numberTender;
    }

    public void setnumberTender(String numberTender) {
        this.numberTender = numberTender;
    }

    public String getbicoTender() {
        return bicoTender;
    }

    public void setbicoTender(String bicoTender) {
        this.bicoTender = bicoTender;
    }

    public String getgosZakupki() {
        return gosZakupki;
    }

    public void setgosZakupki(String gosZakupki) {
        this.gosZakupki = gosZakupki;
    }

    public String gettypetender() {
        return this.typetender.getType();
    }

    public void settypetender(com.keysight.tender.models.Typetender typetender) {
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

    public ZonedDateTime getdateStart() {
        return dateStart;
    }

    public void setdateStart(ZonedDateTime dateStart) {
        this.dateStart = dateStart;
    }

    public ZonedDateTime getdateFinish() {
        return dateFinish;
    }

    public void setdateFinish(ZonedDateTime dateFinish) {
        this.dateFinish = dateFinish;
    }

    public BigDecimal getfullSum() {
        return fullSum;
    }

    public void setfullSum(BigDecimal fullSum) {
        this.fullSum = fullSum;
    }

    public BigDecimal getwinSum() {
        return winSum;
    }

    public void setwinSum(BigDecimal winSum) {
        this.winSum = winSum;
    }

    public String getwinner() {
        return winner.getName();
    }

    public void setwinner(com.keysight.tender.models.Winner winner) {
        this.winner = winner;
    }
}
