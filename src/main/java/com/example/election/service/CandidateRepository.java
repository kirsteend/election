package com.example.election.service;


import com.example.election.domain.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CandidateRepository extends JpaRepository<Candidate, String> {

    public Candidate findByName(String name);
    public List<Candidate> findByParty(String party);

}