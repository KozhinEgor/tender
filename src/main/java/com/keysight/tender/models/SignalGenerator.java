package com.keysight.tender.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import javax.persistence.*;

@Entity
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class SignalGenerator {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long id;
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "vendorSignalGenerator",nullable = false)
    private Vendor vendorSignalGenerator;

    @Column(nullable = false)
    String vendorCode;
    @Column(nullable = false)
    double frequency;

    public SignalGenerator() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Vendor getVendor() {
        return vendorSignalGenerator;
    }

    public void setVendor(Vendor vendor) {
        this.vendorSignalGenerator = vendor;
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
        String vendor = this.vendorSignalGenerator.getName() != "-" ? this.vendorSignalGenerator.getName() : "";
        String vendorCode = this.vendorCode != "-" ? " "+this.vendorCode : "";
        String frequency = this.frequency != 0.0 ? " "+this.frequency : "";

        return vendor+vendorCode+frequency;
    }
}
