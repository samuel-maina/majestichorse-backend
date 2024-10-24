/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.majesticHorse.controllers;

import com.majesticHorse.model.SundayAttendance;
import com.majesticHorse.model.Visitor;
import com.majesticHorse.services.AttendanceService;
import com.majesticHorse.services.VisitorService;
import java.time.LocalDate;
import java.util.Date;
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
@RequestMapping("/api/v1/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;
    
    @Autowired
    private VisitorService visitorService;

    @GetMapping
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(attendanceService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/{member}/{id}")
    public ResponseEntity<?> Save(@PathVariable Long member, @PathVariable Long id) {
        attendanceService.save(member, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> Save(@RequestBody SundayAttendance attendance) {
        attendanceService.save(attendance);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @PostMapping("/visitor/save/{attendance}")
    public ResponseEntity<?> saveVisitor(@RequestBody Visitor visitor,@PathVariable long attendance) {
        visitorService.save(visitor,attendance);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/visitor/view/{attendance}")
    public ResponseEntity<?> findVisitorsByAttendanceId(@PathVariable long attendance) {
        return new ResponseEntity<>(visitorService.findVisitorsByAttendanceId(attendance), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable long id) {
        return new ResponseEntity<>(attendanceService.findById(id), HttpStatus.OK);
    }
}
