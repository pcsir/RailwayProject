package com.example.shubhankar.pcs_ir;

public class PassengerModel {
    private String name,status,seat;
    private long id,pnr;


    public PassengerModel(Long id, String name, String status, String seat, Long pnr) {
        this.name = name;
        this.status = status;
        this.id = 0;
        this.pnr = 0;
        this.seat = seat;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public String getSeat() {
        return seat;
    }

    public long getId() {
        return id;
    }

    public long getPnr() {
        return pnr;
    }

    public String toString(){
        return "ID: " + id + " Title: " + name + " Status: " + status + " Seat No.: " + seat + " PNR: " + pnr;

    }

}
