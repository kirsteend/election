package com.example.election.web;

import com.example.election.domain.Voter;
import com.example.election.service.VoterService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class VoterController {

    private Log log = LogFactory.getLog(this.getClass());
    private VoterService service;

    public VoterController(final VoterService service){
        this.service = service;
    }

    @GetMapping(value = "/voters")
    public ResponseEntity<List<Voter>> getVoters(@RequestParam(value="name", required=false) String name) {
        final List<Voter> result = service.getVoters(name);
        final HttpStatus status = (result.size() == 0) ? HttpStatus.NOT_FOUND : HttpStatus.OK;
        return new ResponseEntity<>(result, status);
    }

    @PostMapping(value = "/voters")
    public ResponseEntity<Voter> addVoter(@RequestBody Voter voter) {
        final Voter result = service.addVoter(voter);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping(value = "/voters")
    public ResponseEntity<Voter> updateVoter(@RequestParam(value="name") String name, @RequestParam(value="newName") String newName) {
        final Voter result = service.updateVoter(name, newName);
        final HttpStatus status = (result == null) ? HttpStatus.BAD_REQUEST : HttpStatus.OK;
        return new ResponseEntity<>(result, status);
    }
}
