package com.example.election.voter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class VoterController {

    private Log log = LogFactory.getLog(this.getClass());

    @Autowired
    private VoterService service;

    @GetMapping(value = "/voters")
    public ResponseEntity<Voter> getVoter(@RequestParam(value="name", required=false) String name) {
        final Voter result = service.getVoter(name);
        final HttpStatus status = (result == null) ? HttpStatus.NOT_FOUND : HttpStatus.OK;
        return new ResponseEntity<>(result, status);
    }

    @PostMapping(value = "/voters")
    public ResponseEntity<Voter> addVoter(@RequestParam(value="name") String name) {
        final Voter result = service.addVoter(name);
        final HttpStatus status = (result == null) ? HttpStatus.BAD_REQUEST : HttpStatus.CREATED;
        return new ResponseEntity<>(result, status);
    }

    @PutMapping(value = "/voters")
    public ResponseEntity<Voter> updateVoter(@RequestParam(value="name") String name, @RequestParam(value="newName") String newName) {
        final Voter result = service.updateVoter(name, newName);
        final HttpStatus status = (result == null) ? HttpStatus.BAD_REQUEST : HttpStatus.OK;
        return new ResponseEntity<>(result, status);
    }
}
