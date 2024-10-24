/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.majesticHorse.controllers;

import com.majesticHorse.model.GeneralContributions;
import com.majesticHorse.model.Sheet;
import com.majesticHorse.model.Tag;
import com.majesticHorse.services.SheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
@RequestMapping("/api/v1/sheet")
public class SheetController {

    @Autowired
    private SheetService sheetService;

    @GetMapping("/{Id}")
    public ResponseEntity<?> getSheetById(@PathVariable String Id) {
        return new ResponseEntity<>(sheetService.getSheetById(Id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAllSheets() {
        return new ResponseEntity<>(sheetService.getAllSheets(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> saveTag(@RequestBody GeneralContributions sheet) {
        sheetService.saveSheet(sheet);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
