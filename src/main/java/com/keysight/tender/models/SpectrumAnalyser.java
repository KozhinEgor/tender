package com.keysight.tender.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import javax.persistence.*;

@Entity
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class SpectrumAnalyser {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
        private Long id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "vendorSpectrumAnalyser",nullable = false)
        private Vendor vendorSpectrumAnalyser;

    @Column(nullable = false)
       private String vendorCode;
    @Column(nullable = false)
        private double frequency;
    @Column(nullable = false)
        private boolean portable = false;
    @Column(nullable = false)
       private boolean usb = false;

    public SpectrumAnalyser() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Vendor getVendor() {
        return vendorSpectrumAnalyser;
    }

    public void setVendor(Vendor vendor) {
        this.vendorSpectrumAnalyser = vendor;
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

    public boolean isPortable() {
        return portable;
    }

    public void setPortable(boolean portable) {
        this.portable = portable;
    }

    public boolean isUsb() {
        return usb;
    }

    public void setUsb(boolean usb) {
        this.usb = usb;
    }

    public String getAnswear(){
        String vendor = !this.vendorSpectrumAnalyser.getName().equals("No vendor") ? this.vendorSpectrumAnalyser.getName() : "";
        String vendorCode = !this.vendorCode.equals("no_vendor_code") ? " "+this.vendorCode : "";
        String frequency = this.frequency != 0.0 ? " "+this.frequency : "";
        String USB = this.usb ? " USB" : "";
        String Portable = this.portable ? " Портативный" : "";

        return vendor+vendorCode+frequency+USB+Portable;
    }
}
