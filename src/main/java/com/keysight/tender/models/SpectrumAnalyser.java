package com.keysight.tender.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import javax.persistence.*;

@Entity
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class SpectrumAnalyser {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
        Long id;
    @Column(nullable = false)
        String vendor;
    @Column(nullable = false)
        String vendorCode;
    @Column(nullable = false)
        double frequency;

    public SpectrumAnalyser() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getVendorCode() {
        return vendorCode;
    }

    public void setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
    }

    public double getFrequency() {
        return frequency;
    }

    public void setFrequency(double frequency) {
        this.frequency = frequency;
    }
}
