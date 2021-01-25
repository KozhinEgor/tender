package com.keysight.tender.models;

import org.springframework.beans.factory.annotation.Autowired;

import java.time.ZonedDateTime;
//{dateStart: '', dateFinish: '', type: '%', custom: '%', winner: '%', minSum: 0, maxSum: 999999999999}
public class ReceivedJSON {
    private ZonedDateTime dateStart;
    private ZonedDateTime dateFinish;
    private String type;
    private String custom;
    private String winner;
    private long minSum;
    private long maxSum;

    public ReceivedJSON() {
    }

    public ReceivedJSON(ZonedDateTime dateStart, ZonedDateTime dateFinish) {

        this.dateStart = dateStart;
        this.dateFinish = dateFinish;
    }

    public ZonedDateTime getDateStart() {
        return dateStart;
    }

    public void setDateStart(ZonedDateTime dateStart) {
        this.dateStart = dateStart;
    }

    public ZonedDateTime getDateFinish() {
        return dateFinish;
    }

    public void setDateFinish(ZonedDateTime dateFinish) {
        this.dateFinish = dateFinish;
    }

    public String getType() {
        return type;
    }

    public String getCustom() {
        return custom;
    }

    public String getWinner() {
        return winner;
    }

    public long getMinSum() {
        return minSum;
    }

    public long getMaxSum() {
        return maxSum;
    }

    public void getRequest(){


        if(this.dateStart == null && this.dateFinish == null){
            this.dateStart = ZonedDateTime.now().minusMonths(1);
            this.dateFinish = ZonedDateTime.now().plusMonths(1);
        }
        else if(this.dateStart == null) {
            this.dateStart = this.dateFinish.minusMonths(2);
        }
        else if (this.dateFinish == null) {
            this.dateFinish = ZonedDateTime.now().plusMonths(1);

        }
        else{
            System.out.println(this.dateStart);
            this.dateStart.plusHours(2);
            System.out.println(this.dateStart);
            this.dateFinish.plusHours(3);
        }

    }
}
