/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.majesticHorse.controllers;

import com.majesticHorse.model.Tag;
import com.majesticHorse.services.TagService;
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
@RequestMapping("/api/v1/tag")
public class TagController {
    
    @Autowired
    private TagService tagService;

    @GetMapping("/{Id}")
    public ResponseEntity<Tag> getTagById(@PathVariable Long Id) {
        return new ResponseEntity<>(tagService.getTagById(Id), HttpStatus.OK);
    }
    
    @GetMapping
    public ResponseEntity<?> getAllTags() {
        return new ResponseEntity<>(tagService.getAllTags(), HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<?> saveTag(@RequestBody Tag tag) {
        tagService.saveTag(tag);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}
