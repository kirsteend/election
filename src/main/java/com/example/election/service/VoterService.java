package com.example.election.service;

import com.example.election.domain.Voter;

import java.util.List;

public interface VoterService {

    List<Voter> getVoters(final String name);
    Voter addVoter(final Voter voter);
    Voter updateVoter(final String name, final String newName);

}
