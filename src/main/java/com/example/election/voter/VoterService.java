package com.example.election.voter;

import com.example.election.poll.Poll;
import com.example.election.poll.PollRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class VoterService {

    private Log log = LogFactory.getLog(this.getClass());

    private VoterRepository voterRepo;
    private PollRepository pollRepo;

    public VoterService(final VoterRepository voterRepo, final PollRepository pollRepo){
        this.voterRepo = voterRepo;
        this.pollRepo = pollRepo;
    }

    /**
     * Get a voter based on the given name.
     * If no name is given a list of all voters will be returned.
     *
     * @param name - name of the voter to get.
     * @return Voter entity.
     */
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
    public Voter addVoter(final Voter voter) {
        Voter voterEntity = null;
        if(voter != null && voter.getName() != null) {
            voterEntity = voterRepo.findByName(voter.getName());
            if (voterEntity == null) {
                String postCode = voter.getPostCode();
                if(postCode != null){
                    Poll poll = pollRepo.findByPostcode(postCode);
                    voter.setPoll(poll);
                }

                voterEntity = voterRepo.save(voter);
                log.debug("added voter");
            } else {
                log.debug("voter already exists");
            }
        } else {
            log.debug("voter name missing");
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
    public Voter updateVoter(final String name, final String newName) {
        Voter result = null;
        if(name != null) {
            log.debug("Search for voter by name");
            Voter voter = voterRepo.findByName(name);
            if (voter != null) {
                log.debug("voter found");
                voter.setName(newName);
                result = voterRepo.save(voter);
                log.debug("voter updated");
            } else {
                log.debug("voter not found");
            }
        }
        return result;
    }
}
