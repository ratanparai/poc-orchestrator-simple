package com.ratanparai.orchestrator.controller;


import com.ratanparai.orchestrator.repository.OlcmRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class OrchestratorController {


    private OlcmRepository olcmRepository;

	public OrchestratorController(OlcmRepository olcmRepository) {
        this.olcmRepository = olcmRepository;
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(olcmRepository.findAll(), HttpStatus.OK);
    }
}