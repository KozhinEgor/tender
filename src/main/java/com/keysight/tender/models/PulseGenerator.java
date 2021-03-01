package com.keysight.tender.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import javax.persistence.*;

@Entity
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class PulseGenerator {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
        Long id;
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "vendorPulseGenerator",nullable = false)
    private Vendor vendorPulseGenerator;

    @Column(nullable = false)
        String vendorCode;
    @Column(nullable = false)
        double frequency;

    public PulseGenerator() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Vendor getVendor() {
        return vendorPulseGenerator;
    }

    public void setVendor(Vendor vendor) {
        this.vendorPulseGenerator = vendor;
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

    public String getAnswear(){
        String vendor = this.vendorPulseGenerator.getName() != "-" ? this.vendorPulseGenerator.getName() : "";
        String vendorCode = this.vendorCode != "-" ? " "+this.vendorCode : "";
        String frequency = this.frequency != 0.0 ? " "+this.frequency : "";


        return vendor+vendorCode+frequency;
    }
}
