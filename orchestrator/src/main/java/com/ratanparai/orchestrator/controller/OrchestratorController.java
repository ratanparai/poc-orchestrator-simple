package com.ratanparai.orchestrator.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.ratanparai.orchestrator.model.Olcm;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/")
public class OrchestratorController {

    private final RestTemplate restTemplate;

	public OrchestratorController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(populList(), HttpStatus.OK);
    }

    private List<Olcm> populList(){
        List<Olcm> data = new ArrayList<>();

        Olcm[] olcms = restTemplate.getForObject("http://cms:8080", Olcm[].class);
        data.addAll(Arrays.asList(olcms));

        Olcm[] olcms2 = restTemplate.getForObject("http://account:8080", Olcm[].class);
        data.addAll(Arrays.asList(olcms2));

        Olcm[] olcms3 = restTemplate.getForObject("http://loan:8080", Olcm[].class);
        data.addAll(Arrays.asList(olcms3));

        return data;
    }
}