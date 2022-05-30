package com.example.tourdefrancebackend.controller;

import com.example.tourdefrancebackend.model.CykelRytter;
import com.example.tourdefrancebackend.repository.CykelRytterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin

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
    public CykelRytter postCykelRytter(@RequestBody CykelRytter cykelRytter) {
        return cykelRytterRepository.save(cykelRytter);
    }


}
