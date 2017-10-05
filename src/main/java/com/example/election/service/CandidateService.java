package com.example.election.service;

import com.example.election.domain.Candidate;

import java.util.List;

public interface CandidateService {

    List<Candidate> getCandidates(final String partyName);
    Candidate addCandidate(final Candidate candidate);
}
