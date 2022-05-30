package com.example.tourdefrancebackend.controller;

import com.example.tourdefrancebackend.model.CykelRytter;
import com.example.tourdefrancebackend.repository.CykelRytterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin()

public class CykelRytterController {

    @Autowired
    CykelRytterRepository cykelRytterRepository;

    // Henter liste af alle cykelrytter
    @GetMapping("/cykelrytter")
    public List<CykelRytter> hentCykelRytter() {
        return cykelRytterRepository.findAll();
    }

    // Opretter cykelrytter
    @PostMapping("/opret/cykelrytter")
    @ResponseStatus(HttpStatus.CREATED)
    public CykelRytter opretCykelRytter(@RequestBody CykelRytter cykelRytter) {
        return cykelRytterRepository.save(cykelRytter);
    }

    // Sletter cykelrytter
    @DeleteMapping("/cykelrytter/{id}")
    public ResponseEntity<String> sletteCykelRytter(@PathVariable int id) {
        try {
            cykelRytterRepository.deleteById(id);
            return new ResponseEntity<>("slette id = " + id, HttpStatus.NOT_FOUND);
        } catch (Exception err) {
            return new ResponseEntity<>("Kunne ikke finde id = " + id, HttpStatus.NOT_FOUND);
        }
    }

    // Update cykelrytter
    @PutMapping("/update/cykelrytter/{id}")
    public ResponseEntity<CykelRytter> updateCykelRytter(@PathVariable int id, @RequestBody CykelRytter cykelRytter) {
        cykelRytter.setRytterId(id);
        Optional<CykelRytter> optionalCykelRytter = cykelRytterRepository.findById(id);
        if (optionalCykelRytter.isPresent()) {
            cykelRytterRepository.save(cykelRytter);
            return new ResponseEntity<>(cykelRytter, HttpStatus.OK);
        } else {
            CykelRytter ikkeFundet = new CykelRytter();
            ikkeFundet.setRytterNavn("Ikke fundet ved hjælp af id:" + id);
            return new ResponseEntity<>(ikkeFundet, HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/cykelrytter/{holdId}")
    public ResponseEntity<List<CykelRytter>> hentAlleCykelrytterFraHold(@PathVariable int holdId) {
        List<CykelRytter> filtreHold = cykelRytterRepository.findAll().stream().filter(cykelRytter -> cykelRytter.getCykelhold().getCykelholdId() == holdId).collect(Collectors.toList());
    return ResponseEntity.status(HttpStatus.OK).body(filtreHold);
    }
}

