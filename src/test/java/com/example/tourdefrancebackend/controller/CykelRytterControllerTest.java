package com.example.tourdefrancebackend.controller;


import com.example.tourdefrancebackend.model.CykelRytter;
import com.example.tourdefrancebackend.repository.CykelRytterRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.event.annotation.BeforeTestMethod;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureTestDatabase
@ActiveProfiles("test")
@TestPropertySource(locations = "application-test.properties")
class CykelRytterControllerTest {

    @Autowired
    private CykelRytterController cykelRytterController;
    @Autowired
    private CykelRytterRepository cykelRytterRepository;

    @BeforeTestMethod
    void setUp() {
        cykelRytterRepository.deleteAll();
    }

    @Test
    void hentCykelRytter() {
    }

    @Test
    void opretCykelRytter() {
        /*
         "rytterId": 1,
        "rytterNavn": "Erik",
        "rytterEfternavn": "Janus",
        "rytterAlder": 232,
        "rytterLand": "Danmark",
        "rytterTid": 267.0,
        "bjergPoint": 12,
        "spurtPoint": 34,
        "cykelhold": null
         */
        CykelRytter cykelRytter = new CykelRytter();

        cykelRytter.setRytterId(1);
        cykelRytter.setRytterNavn("Jakob");
        cykelRytter.setRytterEfternavn("Hansen");
        cykelRytter.setRytterAlder(22);
        cykelRytter.setRytterLand("Danmark");
        cykelRytter.setRytterTid(33);
        cykelRytter.setBjergPoint(56);
        cykelRytter.setSpurtPoint(32);
        cykelRytter.setCykelhold(null);

        cykelRytterController.opretCykelRytter(cykelRytter);

        Optional<CykelRytter> optionalCykelRytter = cykelRytterRepository.findById(1);
        assertThat(optionalCykelRytter.isPresent()).isTrue();
    }

    @Test
    void sletteCykelRytter() {
    }

    @Test
    void updateCykelRytter() {
    }

    @Test
    void hentCykelRytterFraHold() {
    }
}