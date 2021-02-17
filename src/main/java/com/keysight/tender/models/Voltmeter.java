package com.keysight.tender.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import javax.persistence.*;

@Entity
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Voltmeter {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
        long id;
    @Column(nullable = false)
        String vendor;
    @Column(nullable = false)
        String vendor_code;
    @Column(nullable = false)
        String frequency;

    public Voltmeter() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getVendor_code() {
        return vendor_code;
    }

    public void setVendor_code(String vendor_code) {
        this.vendor_code = vendor_code;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }
}
