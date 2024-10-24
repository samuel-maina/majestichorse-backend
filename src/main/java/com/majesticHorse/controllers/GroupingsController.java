package com.majesticHorse.controllers;

import com.majesticHorse.model.Groupings;
import com.majesticHorse.services.GroupService;
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
@RequestMapping("/api/v1/groups")
public class GroupingsController {

    @Autowired
    private GroupService groupService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Groupings groupings) {
        groupService.save(groupings);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> viewAll() {
        return new ResponseEntity<>(groupService.viewAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return new ResponseEntity<>(groupService.findByID(id), HttpStatus.OK);
    }

    @PostMapping("/{id}/{member}")
    public ResponseEntity<?> insertMemberToGroup(@PathVariable Long id, @PathVariable Long member) {
        groupService.insertMemberToGroup(id, member);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
