package com.example.election.voter;

import org.springframework.data.jpa.repository.JpaRepository;


public interface VoterRepository extends JpaRepository<Voter, String> {

    public Voter findByName(String name);

}