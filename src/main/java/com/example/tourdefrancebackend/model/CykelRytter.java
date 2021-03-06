package com.example.tourdefrancebackend.model;

import javax.persistence.*;

@Entity
public class CykelRytter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rytterId;

    @Column(nullable = false)
    private String rytterNavn;

    @Column(nullable = false)
    private String rytterEfternavn;

    @Column(nullable = false)
    private int rytterAlder;

    @Column(nullable = false)
    private String rytterLand;

    @Column(nullable = false)
    private double rytterTid;

    @Column(nullable = false)
    private int bjergPoint;

    @Column(nullable = false)
    private int spurtPoint;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cykelhold_id")
    private Cykelhold cykelhold;

    //Getters og Setters
    public int getRytterId() {
        return rytterId;
    }

    public void setRytterId(int rytterId) {
        this.rytterId = rytterId;
    }

    public String getRytterNavn() {
        return rytterNavn;
    }

    public void setRytterNavn(String rytterNavn) {
        this.rytterNavn = rytterNavn;
    }

    public String getRytterEfternavn() {
        return rytterEfternavn;
    }

    public void setRytterEfternavn(String rytterEfternavn) {
        this.rytterEfternavn = rytterEfternavn;
    }

    public int getRytterAlder() {
        return rytterAlder;
    }

    public void setRytterAlder(int rytterAlder) {
        this.rytterAlder = rytterAlder;
    }

    public double getRytterTid() {
        return rytterTid;
    }

    public void setRytterTid(double rytterTid) {
        this.rytterTid = rytterTid;
    }

    public int getBjergPoint() {
        return bjergPoint;
    }

    public void setBjergPoint(int bjergPoint) {
        this.bjergPoint = bjergPoint;
    }

    public int getSpurtPoint() {
        return spurtPoint;
    }

    public void setSpurtPoint(int spurtPoint) {
        this.spurtPoint = spurtPoint;
    }

    public Cykelhold getCykelhold() {
        return cykelhold;
    }

    public void setCykelhold(Cykelhold cykelhold) {
        this.cykelhold = cykelhold;
    }

    public String getRytterLand() {
        return rytterLand;
    }

    public void setRytterLand(String rytterLand) {
        this.rytterLand = rytterLand;
    }
}
