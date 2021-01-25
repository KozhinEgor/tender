package com.keysight.tender.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import net.bytebuddy.build.ToStringPlugin;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.Entity;
import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;
import java.util.Map;
import java.util.Set;

@Entity
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Typetender {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
        private Long id;
    @Column(unique=true, nullable = false)
        private String type;

    @JsonIgnore
    @XmlTransient
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "typetender")
        private Set<Tender> Tender;

    public Typetender() {
    }

    public Typetender(String type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
