package com.example.shubhankar.pcs_ir;

public class PassengerModel {
    private String name,status,seat;
    private String id,pnr;


    public PassengerModel(String id, String name, String status, String seat, String pnr) {
        this.name = name;
        this.status = status;
        this.id = id;
        this.pnr = pnr;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPnr(String pnr) {
        this.pnr = pnr;
    }

    public String getId() {
        return id;
    }

    public String getPnr() {
        return pnr;
    }

    public String toString(){
        return "ID: " + id + " Title: " + name + " Status: " + status + " Seat No.: " + seat + " PNR: " + pnr;

    }

}
