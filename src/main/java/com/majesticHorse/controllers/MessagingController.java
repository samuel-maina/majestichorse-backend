package com.majesticHorse.controllers;

import com.majesticHorse.model.Message;
import com.majesticHorse.services.MessagingService;
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
@RequestMapping("/api/v1/message")
public class MessagingController {

    @Autowired
    private MessagingService messagingService;

    @PostMapping("/group/{Id}")
    public ResponseEntity<?> messageGroup(@RequestBody Message message, @PathVariable long Id) {
        messagingService.sendGroupMessage(message, Id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/visitors/attendance/{Id}")
    public ResponseEntity<?> messageVisitors(@RequestBody Message message, @PathVariable long Id) {
        messagingService.sendVisitorsMessage(message, Id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/absent/attendance/{Id}")
    public ResponseEntity<?> messageAbsent(@RequestBody Message message, @PathVariable long Id) {
        messagingService.sendAbsentMessage(message, Id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
