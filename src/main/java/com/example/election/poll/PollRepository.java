package com.example.election.poll;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PollRepository extends MongoRepository<Poll, String> {

    public Poll findByName(String name);
    //public List<Poll> findByRiding(String riding);

}