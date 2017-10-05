package com.example.election.domain;


import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Candidate implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @Column(nullable = false)
    public String name;

    @ManyToOne(optional = false)
    private Party party;

    @ManyToOne(optional = false)
    private Poll poll;

    public Candidate() {}

    public Candidate(final String name, final Party party, final Poll poll) {
        this.name = name;
        this.party = party;
        this.poll = poll;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format(
          "Candidate[id='%s', name='%s', party='%s', poll='%s']", id, name, party.toString(), poll.toString());
    }

}
