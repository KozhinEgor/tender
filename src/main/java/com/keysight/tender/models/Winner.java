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
        private String inn;
    @Column(unique=true, length = 11,nullable = false)
        private String ogrn;

    @JsonIgnore
    @XmlTransient
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "winner")
        private Set<Tender> Tender;

    public Winner() {
    }

    public Winner(String name, String inn, String ogrn) {
        this.name = name;
        this.inn = inn;
        this.ogrn = ogrn;
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

    public String getinn() {
        return inn;
    }

    public void setinn(String inn) {
        this.inn = inn;
    }

    public String getogrn() {
        return ogrn;
    }

    public void setogrn(String ogrn) {
        this.ogrn = ogrn;
    }
}
