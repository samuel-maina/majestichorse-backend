/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.majesticHorse.controllers;

import com.majesticHorse.model.Contributions;
import com.majesticHorse.model.Groupings;
import com.majesticHorse.services.ContributionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author samuel
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/contributions")
public class ContributionsController {
    @Autowired
    private ContributionsService contributionService;
     @PostMapping("/{Id}")
    public ResponseEntity<?> save(@RequestBody Contributions con,@PathVariable String Id) {
        contributionService.saveContribution(con,Id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}
