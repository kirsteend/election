package com.example.election.voter;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface VoterRepository extends MongoRepository<Voter, String> {

    public Voter findByName(String name);

}