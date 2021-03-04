package com.keysight.tender.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import javax.persistence.*;

@Entity
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Oscilloscope {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "vendorOscilloscope",nullable = false)
        private Vendor vendorOscilloscope;

    @Column(nullable = false)
    private String vendorCode;
    @Column(nullable = false)
    private double frequency;
    @Column(nullable = false)
    private boolean usb;
    @Column(nullable = false)
    private boolean vxi;

    public Oscilloscope() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Vendor getVendor() {
        return vendorOscilloscope;
    }

    public void setVendor(Vendor vendor) {
        this.vendorOscilloscope = vendor;
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

    public boolean isUsb() {
        return usb;
    }

    public void setUsb(boolean usb) {
        this.usb = usb;
    }

    public boolean isVxi() {
        return vxi;
    }

    public void setVxi(boolean vxi) {
        this.vxi = vxi;
    }

    public String getAnswear(){

        String vendor = !this.vendorOscilloscope.getName().equals("No vendor")  ? this.vendorOscilloscope.getName() : "";
        String vendorCode = !this.vendorCode.equals("no_vendor_code")   ? " "+this.vendorCode : "";
        String frequency = this.frequency != 0.0 ? " "+this.frequency : "";
        String USB = this.usb ? " USB" : "";
        String VXI = this.vxi ? " VXI" : "";
        return vendor+vendorCode+frequency+USB+VXI;
    }
}
