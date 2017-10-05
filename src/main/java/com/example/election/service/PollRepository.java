package com.example.election.service;

import com.example.election.domain.Poll;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PollRepository extends JpaRepository<Poll, String> {

    Poll findByName(String name);
    Poll findByPostcode(String postcode);

}