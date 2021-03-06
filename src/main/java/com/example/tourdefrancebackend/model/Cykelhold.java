package com.example.tourdefrancebackend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Cykelhold {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cykelholdId;

    @Column(nullable = false)
    private String holdNavn;

    @Column(nullable = false)
    private String land;


    @OneToMany
    @JoinColumn(name = "cykelhold_id")
    @JsonBackReference
    private Set<CykelRytter> cykelRytterSet = new HashSet<>();

    public int getCykelholdId() {
        return cykelholdId;
    }

    public void setCykelholdId(int cykelholdId) {
        this.cykelholdId = cykelholdId;
    }

    public String getHoldNavn() {
        return holdNavn;
    }

    public void setHoldNavn(String holdNavn) {
        this.holdNavn = holdNavn;
    }

    public String getLand() {
        return land;
    }

    public void setLand(String land) {
        this.land = land;
    }

    public Set<CykelRytter> getCykelRytterSet() {
        return cykelRytterSet;
    }

    public void setCykelRytterSet(Set<CykelRytter> cykelRytterSet) {
        this.cykelRytterSet = cykelRytterSet;
    }
}
