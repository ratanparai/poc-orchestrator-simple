package com.ratanparai.account.controller;

import java.util.ArrayList;
import java.util.List;

import com.ratanparai.account.model.Olcm;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class AccountController {
    
    @GetMapping
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(generateSampleOlcm(), HttpStatus.OK);
    }

    private List<Olcm> generateSampleOlcm() {
        List<Olcm> data = new ArrayList<>();

        Olcm olcm1 = new Olcm("Account", "You have no money");
        Olcm olcm2 = new Olcm("Taka", "Money honey");

        data.add(olcm1);
        data.add(olcm2);

        return data;

    }
}