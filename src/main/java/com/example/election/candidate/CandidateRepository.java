package com.example.election.candidate;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CandidateRepository extends MongoRepository<Candidate, String> {

    public Candidate findByFirstName(String firstName);
    public List<Candidate> findByParty(String party);

}