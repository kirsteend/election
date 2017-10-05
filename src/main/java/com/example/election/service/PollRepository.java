package com.example.election.service;

import com.example.election.domain.Poll;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PollRepository extends JpaRepository<Poll, String> {

    public Poll findByName(String name);
    public Poll findByPostcode(String postcode);

}