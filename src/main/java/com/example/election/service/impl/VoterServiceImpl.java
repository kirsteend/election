package com.example.election.service.impl;

import com.example.election.domain.Poll;
import com.example.election.domain.Voter;
import com.example.election.service.CandidateRepository;
import com.example.election.service.PollRepository;
import com.example.election.service.VoterRepository;
import com.example.election.service.VoterService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class VoterServiceImpl implements VoterService {

    private Log log = LogFactory.getLog(this.getClass());

    private VoterRepository voterRepo;
    private PollRepository pollRepo;
    private CandidateRepository cRepo;

    public VoterServiceImpl(final VoterRepository voterRepo, final PollRepository pollRepo, final CandidateRepository cRepo){
        this.voterRepo = voterRepo;
        this.pollRepo = pollRepo;
        this.cRepo = cRepo;
    }

    /**
     * Get a voter based on the given name.
     * If no name is given a list of all voters will be returned.
     *
     * @param name - name of the voter to get.
     * @return Voter entity.
     */
    @Override
    public List<Voter> getVoters(final String name) {
        final List<Voter> voters = Collections.synchronizedList(new ArrayList<Voter>());
        if(name != null && name.length() > 0) {
            log.debug("Search for voter by name");
            Voter voter = voterRepo.findByName(name);
            if (voter != null) {
                log.debug("voter found");
                voters.add(voter);
            } else {
                log.debug("voter not found");
            }
        } else {
            log.debug("Get all voters");
            return voterRepo.findAll();
        }
        return voters;
    }

    /**
     * Add a voter with the given name if they do not already exist.
     * Assign them to a poll if one for their given post code exists.
     *
     * @param voter - voter to add.
     * @return Voter entity.
     */
    @Override
    public Voter addVoter(final Voter voter) {
        Assert.notNull(voter, "voter must not be null");
        Assert.notNull(voter.getName(), "voter name must not be null");

        Voter voterEntity = voterRepo.findByName(voter.getName());
        if (voterEntity == null) {
            String postCode = voter.getPostCode();
            log.debug(String.format("postCode: %s", postCode));
            if(postCode != null){
                Poll poll = pollRepo.findByPostcode(postCode);
                log.debug(String.format("poll: %s", poll.toString()));
                voter.setPoll(poll);
            }

            voterEntity = voterRepo.save(voter);
            log.debug("added voter");
        } else {
            log.debug("voter already exists");
        }
        return voterEntity;
    }

    /**
     * Updates a voter's name.
     *
     * @param name - original name
     * @param newName - new name
     * @return voter entity
     */
    @Override
    public Voter updateVoter(final String name, final String newName) {
        Assert.notNull(name, "name must not be null");

        log.debug("Search for voter by name");
        Voter voter = voterRepo.findByName(name);
        if (voter != null) {
            log.debug("voter found");
            voter.setName(newName);
            return voterRepo.save(voter);
        } else {
            return null;
        }
    }
}
