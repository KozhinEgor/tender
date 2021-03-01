package com.keysight.tender.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;


import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;
import java.util.Set;

@Entity
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Vendor {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long id;
    @Column(nullable = false)
        String name;
    @Column(nullable = false)
        String secondName = "-";

    @JsonIgnore

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "vendorSpectrumAnalyser")
        private Set<SpectrumAnalyser> SpectrumAnalyser;

    @JsonIgnore

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "vendorPulseGenerator")
        private Set<PulseGenerator> PulseGenerator;

    @JsonIgnore

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "vendorSignalGenerator")
    private Set<SignalGenerator> SignalGenerator;

        @JsonIgnore

        @OneToMany(fetch = FetchType.LAZY, mappedBy = "vendorSignalAnalyzer")
        private Set<SignalAnalyzer> SignalAnalyzer;

            @JsonIgnore

            @OneToMany(fetch = FetchType.LAZY, mappedBy = "vendorOscilloscope")
                private Set<Oscilloscope> Oscilloscope;


    public Vendor() {
    }

    public Vendor(String name) {
        this.name = name;
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

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }
}
