package com.keysight.tender.models;

import java.time.LocalDateTime;

public class ReceivedJSON {
    private LocalDateTime dateStart;
    private LocalDateTime dateFinish;

    public ReceivedJSON() {
    }

    public ReceivedJSON(LocalDateTime dateStart, LocalDateTime dateFinish) {
        this.dateStart = dateStart;
        this.dateFinish = dateFinish;
    }

    public LocalDateTime getDateStart() {
        return dateStart;
    }

    public void setDateStart(LocalDateTime dateStart) {
        this.dateStart = dateStart;
    }

    public LocalDateTime getDateFinish() {
        return dateFinish;
    }

    public void setDateFinish(LocalDateTime dateFinish) {
        this.dateFinish = dateFinish;
    }
}
