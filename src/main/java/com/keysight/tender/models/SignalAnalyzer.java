package com.keysight.tender.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import javax.persistence.*;

@Entity
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class SignalAnalyzer {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "vendorSignalAnalyzer",nullable = false, insertable = false, updatable = false)
    private Vendor vendorSignalAnalyzer;

    @Column(nullable = false)
    private String vendorCode;
    @Column(nullable = false)
    private double frequency;

    public SignalAnalyzer() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Vendor getVendor() {
        return vendorSignalAnalyzer;
    }

    public void setVendor(Vendor vendor) {
        this.vendorSignalAnalyzer = vendor;
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
        String vendor = !this.vendorSignalAnalyzer.getName().equals("No vendor") ? this.vendorSignalAnalyzer.getName() : "";
        String vendorCode = !this.vendorCode.equals("no_vendor_code") ? " "+this.vendorCode : "";
        String frequency = this.frequency != 0.0 ? " "+this.frequency : "";


        return vendor+vendorCode+frequency;
    }
}
