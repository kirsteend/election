package com.example.election.riding;

import com.example.election.candidate.Candidate;
import com.example.election.poll.Poll;

import javax.persistence.*;
import java.util.List;

@Entity
public class Riding {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    public String name;

    public Riding() {}

    public Riding(final String name) {
        this.name = name;
    }

    @OneToMany(cascade = CascadeType.ALL)
    public List<Poll> polls;

    @OneToMany(cascade = CascadeType.ALL)
    public List<Candidate> candidates;
}
