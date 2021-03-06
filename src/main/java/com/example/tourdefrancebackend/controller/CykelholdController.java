package com.example.tourdefrancebackend.controller;

import com.example.tourdefrancebackend.repository.CykelholdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class CykelholdController {

    @Autowired
    CykelholdRepository cykelholdRepository;

    // Henter alle holdene
    @GetMapping("/cykelhold")
    public List<com.example.tourdefrancebackend.model.Cykelhold> henteCykelHold() {
        return cykelholdRepository.findAll();
    }


}
