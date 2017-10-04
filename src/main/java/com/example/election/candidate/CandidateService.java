package com.example.election.candidate;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateService {

    private Log log = LogFactory.getLog(this.getClass());

    private CandidateRepository candidateRepo;

    public CandidateService(final CandidateRepository candidateRepo){
        this.candidateRepo = candidateRepo;
    }

    /**
     * Get a candidate based on the given partyName.
     * If no partyName is given a list of all candidates will be returned.
     *
     * @param partyName - partyName of the candidate to get.
     * @return Candidate entity.
     */
    public List<Candidate> getCandidates(final String partyName) {
        if(partyName != null) {
            log.debug("Search for candidate by name");
            return candidateRepo.findByParty(partyName);
        } else {
            log.debug("Get all candidates");
            return candidateRepo.findAll();
        }
    }

    /**
     * Add a candidate with the given name if they do not already exist.
     *
     * @param candidate - candidate to add.
     * @return Candidate entity.
     */
    public Candidate addCandidate(final Candidate candidate) {
        Candidate candidateEntity = null;
        if(candidate != null && candidate.getName() != null) {
            candidateEntity = candidateRepo.findByName(candidate.getName());
            if (candidateEntity == null) {
                candidateEntity = candidateRepo.save(candidate);
                log.debug("added candidate");
            } else {
                log.debug("candidate already exists");
            }
        }

        return candidateEntity;
    }

}
