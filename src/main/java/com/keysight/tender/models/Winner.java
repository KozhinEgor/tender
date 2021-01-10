package com.keysight.tender.models;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;
import java.util.Set;

@Entity
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Winner {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
        private Long id;
    @Column(unique = true,nullable = false)
        private String name;
    @Column(unique=true, length = 11,nullable = false)
        private String INN;
    @Column(unique=true, length = 11,nullable = false)
        private String OGRN;

    @JsonIgnore
    @XmlTransient
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "Winner")
        private Set<Tender> Tender;

    public Winner() {
    }

    public Winner(String name, String INN, String OGRN) {
        this.name = name;
        this.INN = INN;
        this.OGRN = OGRN;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String Name) {
        name = Name;
    }

    public String getINN() {
        return INN;
    }

    public void setINN(String INN) {
        this.INN = INN;
    }

    public String getOGRN() {
        return OGRN;
    }

    public void setOGRN(String OGRN) {
        this.OGRN = OGRN;
    }
}
