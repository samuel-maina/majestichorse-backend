package com.majesticHorse.controllers;

import com.majesticHorse.model.Congregant;
import com.majesticHorse.services.MemberService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author samuel
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/members")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @PostMapping
    public ResponseEntity<?> saveMember(@RequestBody Congregant cog) {
        memberService.saveMember(cog);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/batch")
    public ResponseEntity<?> saveMembers(@RequestBody List<Congregant> cog) {
        memberService.saveMembers(cog);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> members() {
        return new ResponseEntity<>(memberService.members(), HttpStatus.OK);
    }

    @GetMapping("/attendance/{id}")
    public ResponseEntity<?> membersAttendanceByDate(@PathVariable Long id) {
        return new ResponseEntity<>(memberService.getmembersNotInAttendance(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Congregant cog, @PathVariable long id) {
        memberService.updateMember(id, cog);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        memberService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable long id) {

        return new ResponseEntity<>(memberService.findById(id), HttpStatus.OK);
    }
}
