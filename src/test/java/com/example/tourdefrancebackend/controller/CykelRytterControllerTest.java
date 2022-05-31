package com.example.tourdefrancebackend.controller;


import com.example.tourdefrancebackend.model.CykelRytter;
import com.example.tourdefrancebackend.model.Cykelhold;
import com.example.tourdefrancebackend.repository.CykelRytterRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.event.annotation.BeforeTestMethod;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureTestDatabase
@ActiveProfiles("test")
@TestPropertySource(locations = "classpath:application-test.properties")
class CykelRytterControllerTest {

    @Autowired
    private CykelRytterController cykelRytterController;
    @Autowired
    private CykelRytterRepository cykelRytterRepository;

    @BeforeTestMethod
    void setUp() {
        cykelRytterRepository.deleteAll();
    }

    // Test til at oprette cykelrytter
    @Test
    void opretCykelRytter() {

        CykelRytter cykelRytter = new CykelRytter();

        cykelRytter.setRytterNavn("Jakob");
        cykelRytter.setRytterEfternavn("Hansen");
        cykelRytter.setRytterAlder(22);
        cykelRytter.setRytterLand("Danmark");
        cykelRytter.setRytterTid(33);
        cykelRytter.setBjergPoint(56);
        cykelRytter.setSpurtPoint(32);

        Cykelhold cykelhold = new Cykelhold();
        cykelhold.setHoldNavn("JEns");
        cykelhold.setLand("Norge");
        cykelRytter.setCykelhold(cykelhold);


        cykelRytterController.opretCykelRytter(cykelRytter);

        Optional<CykelRytter> optionalCykelRytter = cykelRytterRepository.findById(cykelRytter.getRytterId());

        assertThat(optionalCykelRytter.isPresent()).isTrue();
        assertEquals("Jakob", optionalCykelRytter.get().getRytterNavn());
    }

    @Test
    void sletteCykelRytter() {
    }

    /*
        @Test
        void updateCykelRytter() {
            CykelRytter cykelRytter = new CykelRytter();
            cykelRytter.setRytterId(2);
            cykelRytter.setRytterNavn("Jonas");
            cykelRytter.setRytterEfternavn("Tohmsen");
            cykelRytter.setRytterAlder(23);
            cykelRytter.setRytterLand("Sverige");
            cykelRytter.setRytterTid(21);
            cykelRytter.setSpurtPoint(32);
            cykelRytter.setBjergPoint(32);
            cykelRytter.setCykelhold(null);

            cykelRytterController.updateCykelRytter(2, new CykelRytter());

            Optional<CykelRytter> optionalCykelRytter = cykelRytterRepository.findById(2);
            assertThat("")
        }


     */
    @Test
    void hentCykelRytterFraHold() {
    }
}