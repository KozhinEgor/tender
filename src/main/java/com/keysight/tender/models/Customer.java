package com.keysight.tender.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;
import java.util.Set;

@Entity
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Customer {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
        private Long id;
    @Column(nullable = true)
        private String INN;
    @Column(nullable = false)
        private String name;

    @JsonIgnore
    @XmlTransient
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "Customer")
        private Set<Tender> Tender;

    public Customer() {
    }

    public Customer(String INN, String name) {
        this.INN = INN;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getINN() {
        return INN;
    }

    public void setINN(String INN) {
        this.INN = INN;
    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

}
