package com.example.election.service;

import com.example.election.domain.Voter;
import org.springframework.data.jpa.repository.JpaRepository;


public interface VoterRepository extends JpaRepository<Voter, String> {

    public Voter findByName(String name);

}