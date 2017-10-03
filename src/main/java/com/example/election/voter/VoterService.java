package com.example.election.voter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class VoterService {

    private Log log = LogFactory.getLog(this.getClass());

    @Autowired
    private VoterRepository repository;

    /**
     * Get a voter based on the given name.
     * If no name is given a list of all voters will be returned.
     *
     * @param name - name of the voter to get.
     * @return Voter entity.
     */
    public List<Voter> getVoters(final String name) {
        final List<Voter> voters = Collections.synchronizedList(new ArrayList<Voter>());
        if(name != null) {
            log.debug("Search for voter by name");
            Voter voter = repository.findByFirstName(name);
            if (voter != null) {
                log.debug("voter found");
                voters.add(voter);
            } else {
                log.debug("voter not found");
            }
        } else {
            log.debug("Get all voters");
            return repository.findAll();
        }
        return voters;
    }

    /**
     * Add a voter with the given name if they do not already exist.
     *
     * @param name - name of voter to add.
     * @return Voter entity.
     */
    public Voter addVoter(final String name) {
        Voter voter = repository.findByFirstName(name);
        if(voter == null){
            voter = repository.save(new Voter(name, "lastName"));
            log.debug("added voter");
        } else {
            log.debug("voter already exists");
        }

        return voter;
    }

    /**
     * Updates a voter's name.
     *
     * @param name - original name
     * @param newName - new name
     * @return voter entity
     */
    public Voter updateVoter(final String name, final String newName) {
        Voter result = null;
        if(name != null) {
            log.debug("Search for voter by name");
            Voter voter = repository.findByFirstName(name);
            if (voter != null) {
                log.debug("voter found");
                voter.setFirstName(newName);
                result = repository.save(voter);
                log.debug("voter updated");
            } else {
                log.debug("voter not found");
            }
        }
        return result;
    }
}
