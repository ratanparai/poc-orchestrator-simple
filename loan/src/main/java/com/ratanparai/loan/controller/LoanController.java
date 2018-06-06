package com.ratanparai.loan.controller;

import java.util.ArrayList;
import java.util.List;

import com.ratanparai.loan.model.Olcm;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class LoanController {

    @GetMapping
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(generateSampleOlcm(), HttpStatus.OK);
    }

    private List<Olcm> generateSampleOlcm() {
        List<Olcm> data = new ArrayList<>();

        Olcm olcm1 = new Olcm("Loan", "Or no loan");
        Olcm olcm2 = new Olcm("Buy anyting", "No need to have any money");

        data.add(olcm1);
        data.add(olcm2);

        return data;

    }
}