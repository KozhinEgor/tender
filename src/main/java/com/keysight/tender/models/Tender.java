package com.keysight.tender.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.mapping.Set;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Tender {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
        Long id;
    @JsonIgnore
    @XmlTransient
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "CustomerId",nullable = false)
        private  Customer Customer;
    @Lob
    @Column(nullable = false, length = 512)
        private String nameTender;
    @Column(nullable = false)
        private String numberTender;
    @Column(nullable = false)
        private String bicoTender;
    @Lob
    @Column(nullable = false)
        private String gosZakupki;

    @JsonIgnore
    @XmlTransient
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "typeId", nullable = false)
        private Typetender Typetender;
    @Column(nullable = false)
        private BigDecimal price;
    @Column(nullable = false)
        private String currency;
    @Column(nullable = false)
        private double rate;
    @Column(nullable = false)
        private BigDecimal sum;


    @Column(nullable = false)
        private LocalDateTime dateStart;


    @Column(nullable = false)
        private  LocalDateTime dateFinish;
    @Column(nullable = false)
        private BigDecimal fullSum;
    @Column(nullable = false)
        private BigDecimal winSum;

    @JsonIgnore
    @XmlTransient
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "winnerId",nullable = false)
        private Winner Winner;

    public Tender() {
    }

    public Tender(com.keysight.tender.models.Customer customer,
                  String nameTender, String numberTender, String bicoTender,
                  String gosZakupki, com.keysight.tender.models.Typetender typetender,
                  BigDecimal price, String currency, double rate,
                  LocalDateTime dateStart, LocalDateTime dateFinish,
                  com.keysight.tender.models.Winner winner) {
        Customer = customer;
        this.nameTender = nameTender;
        this.numberTender = numberTender;
        this.bicoTender = bicoTender;
        this.gosZakupki = gosZakupki;
        Typetender = typetender;
        this.price = price;
        this.currency = currency;
        this.rate = rate;
        this.sum = new BigDecimal(rate).multiply(price);
        this.dateStart = dateStart;
        this.dateFinish = dateFinish;
        fullSum = sum;
        winSum = new BigDecimal(0);
        Winner = winner;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomer() {
        return Customer.getname();
    }

    public void setCustomer(com.keysight.tender.models.Customer customer) {
        Customer = customer;
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

    public String getTypetender() {
        return Typetender.getType();
    }

    public void setTypetender(com.keysight.tender.models.Typetender typetender) {
        Typetender = typetender;
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

    public LocalDateTime getdateStart() {
        return dateStart;
    }

    public void setdateStart(LocalDateTime dateStart) {
        this.dateStart = dateStart;
    }

    public LocalDateTime getdateFinish() {
        return dateFinish;
    }

    public void setdateFinish(LocalDateTime dateFinish) {
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

    public String getWinner() {
        return Winner.getName();
    }

    public void setWinner(com.keysight.tender.models.Winner winner) {
        Winner = winner;
    }
}
