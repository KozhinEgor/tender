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
        private String NameTender;
    @Column(nullable = false)
        private String NumberTender;
    @Column(nullable = false)
        private String BicoTender;
    @Lob
    @Column(nullable = false)
        private String GosZakupki;

    @JsonIgnore
    @XmlTransient
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "TypeId", nullable = false)
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
        private java.time.LocalDate DateStart;
    @Column(nullable = false)
        private  java.time.LocalDateTime DateFinish;
    @Column(nullable = false)
        private BigDecimal FullSum;
    @Column(nullable = false)
        private BigDecimal WinSum;

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
                  LocalDate dateStart, LocalDateTime dateFinish,
                  com.keysight.tender.models.Winner winner) {
        Customer = customer;
        NameTender = nameTender;
        NumberTender = numberTender;
        BicoTender = bicoTender;
        GosZakupki = gosZakupki;
        Typetender = typetender;
        this.price = price;
        this.currency = currency;
        this.rate = rate;
        this.sum = new BigDecimal(rate).multiply(price);
        DateStart = dateStart;
        DateFinish = dateFinish;
        FullSum = sum;
        WinSum = new BigDecimal(0);
        Winner = winner;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public com.keysight.tender.models.Customer getCustomer() {
        return Customer;
    }

    public void setCustomer(com.keysight.tender.models.Customer customer) {
        Customer = customer;
    }

    public String getNameTender() {
        return NameTender;
    }

    public void setNameTender(String nameTender) {
        NameTender = nameTender;
    }

    public String getNumberTender() {
        return NumberTender;
    }

    public void setNumberTender(String numberTender) {
        NumberTender = numberTender;
    }

    public String getBicoTender() {
        return BicoTender;
    }

    public void setBicoTender(String bicoTender) {
        BicoTender = bicoTender;
    }

    public String getGosZakupki() {
        return GosZakupki;
    }

    public void setGosZakupki(String gosZakupki) {
        GosZakupki = gosZakupki;
    }

    public com.keysight.tender.models.Typetender getTypetender() {
        return Typetender;
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

    public LocalDate getDateStart() {
        return DateStart;
    }

    public void setDateStart(LocalDate dateStart) {
        DateStart = dateStart;
    }

    public LocalDateTime getDateFinish() {
        return DateFinish;
    }

    public void setDateFinish(LocalDateTime dateFinish) {
        DateFinish = dateFinish;
    }

    public BigDecimal getFullSum() {
        return FullSum;
    }

    public void setFullSum(BigDecimal fullSum) {
        FullSum = fullSum;
    }

    public BigDecimal getWinSum() {
        return WinSum;
    }

    public void setWinSum(BigDecimal winSum) {
        WinSum = winSum;
    }

    public com.keysight.tender.models.Winner getWinner() {
        return Winner;
    }

    public void setWinner(com.keysight.tender.models.Winner winner) {
        Winner = winner;
    }
}
