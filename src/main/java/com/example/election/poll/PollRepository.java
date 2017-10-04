package com.example.election.poll;

import org.springframework.data.mongodb.repository.MongoRepository;


public interface PollRepository extends MongoRepository<Poll, String> {

    public Poll findByName(String name);
    public Poll findByPostalCodeOrderByName(String postalCode);

}