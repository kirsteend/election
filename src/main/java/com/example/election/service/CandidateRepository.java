package com.example.election.service;


import com.example.election.domain.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CandidateRepository extends JpaRepository<Candidate, String> {

    Candidate findByName(String name);
    List<Candidate> findByParty(String party);

}